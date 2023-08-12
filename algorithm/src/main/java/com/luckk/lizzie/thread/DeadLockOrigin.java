package com.luckk.lizzie.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liukun.inspire
 * @Date 2023/7/24 23:22
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: DeadLockOrigin
 * @Version 1.0
 */
public class DeadLockOrigin {

    static ReentrantLock r1 = new ReentrantLock();
    static ReentrantLock r2 = new ReentrantLock();
    static Semaphore t1Semphore = new Semaphore(1);
    static Semaphore t2Semphore = new Semaphore(0);

    static Object lock1 = new Object();
    static Object lock2 = new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                t1Semphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock1) {
                System.out.println("获取到R1锁" + Thread.currentThread().getName());
                t2Semphore.release();
                try {
                    t1Semphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("获取到R2锁" + Thread.currentThread().getName());
                }
            }
        }, "thread1");


        Thread thread2 = new Thread(() -> {
            try {
                t2Semphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                System.out.println("获取到r2锁" + Thread.currentThread().getName());
                t1Semphore.release();
                synchronized (lock1) {
                    System.out.println("获取到R1锁" + Thread.currentThread().getName());
                }
            }
        }, "thread2");
        thread1.start();
        thread2.start();

    }
}
