package com.luckk.lizzie.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author liukun.inspire
 * @Date 2023/3/14 17:25
 * @PackageName:com.luckk.lizzie.thread
 * @ClassName: AbPrint
 * @Version 1.0
 */
public class AbPrint {

    /**
     * 这个方案为什么不好，因为现在是2个线程交替打印不同的值，那如果N个不同的线程，交替打印呢
     *
     *
     */
    private static Semaphore thread1Seamphore = new Semaphore(1);

    private static Semaphore thread2Semaphore = new Semaphore(0);
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    thread1Seamphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("1");
                thread2Semaphore.release();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {

                try {
                    thread2Semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("a");
                thread1Seamphore.release();
            }
        });
        thread.start();
        t2.start();
    }
}
