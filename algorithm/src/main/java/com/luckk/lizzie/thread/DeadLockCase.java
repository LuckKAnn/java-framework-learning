package com.luckk.lizzie.thread;

import org.apache.tomcat.jni.Time;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 17:05
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: DeadLockCase
 * @Version 1.0
 */

public class DeadLockCase {

    static ReentrantLock r1 = new ReentrantLock();
    static ReentrantLock r2 = new ReentrantLock();
    static Semaphore t1Semphore = new Semaphore(1);
    static Semaphore t2Semphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            try {
                t1Semphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r1.lock();
            t2Semphore.release();
            System.out.println("获取到r1锁" + Thread.currentThread().getName());

            try {
                t1Semphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r2.lock();
            System.out.println("获取到R2锁" + Thread.currentThread().getName());
        }, "thread1");


        Thread thread2 = new Thread(() -> {
            try {
                t2Semphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r2.lock();
            System.out.println("获取到r2锁" + Thread.currentThread().getName());
            t1Semphore.release();
            r1.lock();
            System.out.println("获取到R1锁" + Thread.currentThread().getName());
        }, "thread2");
        thread1.start();
        thread2.start();

    }

}
