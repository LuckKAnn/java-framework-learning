package com.luckk.lizzie.thread;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liukun.inspire
 * @Date 2023/4/4 23:51
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: AutoCloseLock02
 * @Version 1.0
 */
public class AutoCloseLock02 implements Closeable {


    // 在 try-with-resources 中，catch 和 finally 中的代码在资源关闭之后运行。
    private final ReentrantLock lock;

    public AutoCloseLock02(ReentrantLock lock) {
        this.lock = lock;
        lock.lock();
        System.out.println("lock2加锁" + Thread.currentThread().getName());
    }

    @Override
    public void close() throws IOException {
        lock.unlock();
    }

    public static void main(String[] args) throws Exception {

        ReentrantLock rlock = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        AutoCloseLock autoCloseLock = new AutoCloseLock(rlock);

        // 在 try-with-resources 中，catch 和 finally 中的代码在资源关闭之后运行。
        Thread t1 = new Thread(() -> {
            try (AutoCloseLock.AutoLock autoLock = autoCloseLock.getLock();
                 AutoCloseLock02 autoCloseLock02 = new AutoCloseLock02(lock2)) {
                System.out.println("getLock" + Thread.currentThread().getName());
                int i = 10 / 0;
            } catch (Exception e) {
                System.out.println("抛出异常");
            }
            System.out.println("unlock" + Thread.currentThread().getName());
        }, "t1");

        Thread t2 = new Thread(() -> {
            try (AutoCloseLock.AutoLock autoLock = autoCloseLock.getLock();
                 AutoCloseLock02 autoCloseLock02 = new AutoCloseLock02(lock2)) {

                System.out.println("getLock" + Thread.currentThread().getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("unlock" + Thread.currentThread().getName());
        }, "t2");

        t1.start();
        t2.start();

    }
}
