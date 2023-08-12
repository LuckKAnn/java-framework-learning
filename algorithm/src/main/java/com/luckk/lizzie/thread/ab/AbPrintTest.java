package com.luckk.lizzie.thread.ab;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Author liukun.inspire
 * @Date 2023/7/6 23:53
 * @PackageName: com.luckk.lizzie.thread.ab
 * @ClassName: AbPrintTest
 * @Version 1.0
 */
public class AbPrintTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {

        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Thread t1 = new Thread(new AbTask(a, b, "a"), "t1");
        Thread t2 = new Thread(new AbTask(b, a, "b"), "t2");
        t1.start();
        t2.start();
        // countDownLatch.await();

        t1.join();
        t2.join();

    }
}
