package com.luckk.lizzie.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liukun.inspire
 * @Date 2023/9/1 17:08
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: ThreadExecutorUse
 * @Version 1.0
 */
public class ThreadExecutorUse {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();
    private static Object object = new Object();
    public static void main(String[] args) {


        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1,1,10L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            executorService.submit(()->{
                lock.lock();
                try {
                    condition.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
                System.out.println("执行完成");
            });
        }
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }
}
