package com.luckk.lizzie.blockingQueue;

import java.util.concurrent.DelayQueue;

/**
 * @Author liukun.inspire
 * @Date 2023/3/29 14:19
 * @PackageName: com.luckk.lizzie.blockingQueue
 * @ClassName: DelayQueueTest
 * @Version 1.0
 */

public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        for (int i = 0; i < 10; i++) {

            delayQueue.put(new DelayedElement(2000));
        }

        Thread thread = new Thread(new DelayQueueConsumer(delayQueue));
        thread.start();

        // Thread t2 = new Thread(new DelayQueueConsumer(delayQueue));
        // t2.start();

    }
}
