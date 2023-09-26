package com.luckk.lizzie;

import lombok.SneakyThrows;
import reactor.core.scheduler.Scheduler;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liukun.inspire
 * @Date 2023/9/24 16:33
 * @PackageName: com.luckk.lizzie
 * @ClassName: LuckThreadPool
 * @Version 1.0
 */
public class LuckThreadPool implements Executor {


    private int coreSize;

    private int maxSize;

    private BlockingQueue<Runnable> taskList;

    private TimeUnit timeUnit;

    private Integer timeSecond;

    private LuckRejectPolicy rejectPolicy;

    private ThreadFactory threadFactory;

    private Set<LuckWorker> workerPool = new HashSet<>();


    private AtomicInteger ctl = new AtomicInteger(0);

    private ReentrantLock lock = new ReentrantLock();

    private static final int SIZE_NUM = Integer.SIZE - 3;

    private static final int SIZE_MASK = (1 << SIZE_NUM) - 1;


    private static final int RUNNING = -1 << SIZE_NUM;


    private static final int SHUTDOWN = 0;

    private static int runState(int c) {
        return c & ~SIZE_MASK;
    }

    private static int workerCount(int c) {
        return c & SIZE_MASK;
    }

    public LuckThreadPool() {
        this(1, 2, new ArrayBlockingQueue<>(2), TimeUnit.SECONDS, 1, new LuckCallRunnerRejectPolicy(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "my-luck-thread:" + UUID.randomUUID());
            }
        });
    }

    public LuckThreadPool(int coreSize, int maxSize, BlockingQueue<Runnable> taskList, TimeUnit timeUnit, Integer timeSecond, LuckRejectPolicy rejectPolicy, ThreadFactory threadFactory) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.taskList = taskList;
        this.timeUnit = timeUnit;
        this.timeSecond = timeSecond;
        this.rejectPolicy = rejectPolicy;
        this.threadFactory = threadFactory;
        // 从这里开始吧
    }

    @Override
    public void execute(Runnable command) {
        if (ctl.get() < coreSize) {
            // 创建新的worker
            LuckWorker luckWorker = new LuckWorker(command);
            ctl.incrementAndGet();
        } else if (taskList.offer(command)) {
            return;
        } else if (ctl.get() >= coreSize && ctl.get() <= maxSize) {
            // 创建新的worker
            LuckWorker luckWorker = new LuckWorker();
            ctl.incrementAndGet();
        } else {
            // 执行拒绝策略
            rejectPolicy.reject(command);
        }
    }

    private boolean addWorker(Runnable command, boolean core) {
        // 涉及到CAS的问题
        retry:
        for (; ; ) {
            for (; ; ) {
                int c = ctl.get();
                int runState = runState(c);
                // state 判断
                if (ctl.compareAndSet(c, c + 1)) {
                    // 增加成功，是不是就因为这应该新增worker
                    break retry;
                }
                // 失败，需要进行重试
                // 此阶段state已经发生改变
            }

        }


        boolean workerStarted = false;
        LuckWorker worker = new LuckWorker(command);

        Thread taskThread = worker.taskThread;

        lock.lock();
        try {
            if (taskThread != null) {
                // 需要判断的是是否进行启动
                if (taskThread.isAlive()) {
                    // 已经启动了
                    throw new IllegalStateException();
                }
                taskThread.start();
                workerStarted = true;
            }
        } catch (Exception e) {
            if (!workerStarted) {
                // 关闭我们的机器
                ctl.compareAndSet(ctl.get(), SHUTDOWN);
            }
        } finally {
            lock.unlock();
        }
        return true;
        // 后续，真正创建worker
    }


    private void shutDown() {
        do {
        } while (!ctl.compareAndSet(ctl.get(), SHUTDOWN));
    }


    private void shutDownNow() {
        // 这个是需要进入到stop，所有的任务也都不能执行了吧
        do {
        } while (!ctl.compareAndSet(ctl.get(), SHUTDOWN));
    }

    private final class LuckWorker extends AbstractQueuedSynchronizer implements Runnable {

        private Runnable firstTask;

        private Thread taskThread;

        LuckWorker() {

        }

        LuckWorker(Runnable command) {
            this.firstTask = command;
            this.taskThread = threadFactory.newThread(this);
        }

        @SneakyThrows
        @Override
        public void run() {
            // 执行完成之后结束
            // 是不是需要归还回去呢
            while (firstTask != null || (firstTask = taskList.take()) != null) {
                try {
                    firstTask.run();
                } catch (Exception e) {

                } finally {
                    firstTask = null;
                }
            }
        }
    }


    static class AbortRejectPolicy implements LuckRejectPolicy {
        @Override
        public void reject(Runnable runnable) {
            throw new LuckTaskAbortException();
        }
    }

    static class LuckCallRunnerRejectPolicy implements LuckRejectPolicy {
        @Override
        public void reject(Runnable runnable) {
            runnable.run();
        }
    }

}
