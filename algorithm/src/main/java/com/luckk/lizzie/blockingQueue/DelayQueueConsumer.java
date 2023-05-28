package com.luckk.lizzie.blockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @Author liukun.inspire
 * @Date 2023/3/29 14:38
 * @PackageName: com.luckk.lizzie.blockingQueue
 * @ClassName: DelayQueueConsumer
 * @Version 1.0
 */
public class DelayQueueConsumer implements Runnable {
    DelayQueue delayQueue;

    public DelayQueueConsumer(DelayQueue delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {

        while (true) {
            Delayed take = null;
            try {
                take = delayQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            ((DelayedElement) take).executeTask();
        }

    }
}
