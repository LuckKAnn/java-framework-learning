package com.luckk.lizzie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author liukun.inspire
 * @Date 2023/9/24 17:07
 * @PackageName: com.luckk.lizzie
 * @ClassName: LuckBlockingQueueTest
 * @Version 1.0
 */
class LuckBlockingQueueTest {

    static LuckBlockingQueue<Integer> luckBlockingQueue = new LuckBlockingQueue<>();
    @Test
    void offer() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true){
                // System.out.println(luckBlockingQueue.take());
                System.out.println(String.join(":", Thread.currentThread().getName(), String.valueOf(luckBlockingQueue.take(2000))));
            }
        }, "t1");
        Thread t3 = new Thread(() -> {
            while (true){

                System.out.println(String.join(":", Thread.currentThread().getName(), String.valueOf(luckBlockingQueue.take())));
                // System.out.println(Thread.currentThread().getName() + ":"+ luckBlockingQueue.take());
            }
        }, "t3");
        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                luckBlockingQueue.offer(i);
            }
        }, "t1");

        t1.start();
        // t2.start();
        t3.start();
        t1.join();
        t2.join();
        // t3.join();
    }
}