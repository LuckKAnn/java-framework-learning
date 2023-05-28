package com.luckk.lizzie.thread;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liukun.inspire
 * @Date 2023/4/4 23:31
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: AutoCloseLock
 * @Version 1.0
 */
public class AutoCloseLock extends ReentrantLock {

    public interface AutoLock extends Closeable {
        void close();
    }

    private final ReentrantLock reentrantLock;

    public AutoCloseLock(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    public AutoLock getLock() {
        reentrantLock.lock();
        return new AutoLock() {
            @Override
            public void close() {
                reentrantLock.unlock();
            }
        };
    }

    public static void main(String[] args) throws Exception {

        ReentrantLock rlock = new ReentrantLock();
        AutoCloseLock autoCloseLock = new AutoCloseLock(rlock);

        Thread t1 = new Thread(() -> {
            try (AutoLock autoLock = autoCloseLock.getLock()) {

                System.out.println("getLock" + Thread.currentThread().getName());
                int i = 10/0;
            }catch (Exception e){
                System.out.println("抛出异常");
            }
            System.out.println("unlock" + Thread.currentThread().getName());
        }, "t1");

        Thread t2 = new Thread(() -> {
            try (AutoLock autoLock = autoCloseLock.getLock()) {

                System.out.println("getLock" + Thread.currentThread().getName());
            }
            System.out.println("unlock" + Thread.currentThread().getName());
        }, "t2");

        t1.start();
        t2.start();

    }

}
