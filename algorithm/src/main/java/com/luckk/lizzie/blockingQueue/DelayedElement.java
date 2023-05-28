package com.luckk.lizzie.blockingQueue;

import java.util.Random;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author liukun.inspire
 * @Date 2023/3/29 14:19
 * @PackageName: com.luckk.lizzie.blockingQueue
 * @ClassName: DelayedElement
 * @Version 1.0
 */
public class DelayedElement implements Delayed {

    private final long scheduleTime;

    private final long taskCost;

    public static  long startTime = System.currentTimeMillis();


    public DelayedElement(long taskCost) {
        startTime = startTime + (1000 + (long) (Math.random() * 1000));

        scheduleTime = startTime;
        // this.scheduleTime = scheduleTime;
        this.taskCost = taskCost;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long expirationTime = scheduleTime - System.currentTimeMillis();
        return unit.convert(expirationTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.scheduleTime - ((DelayedElement) o).scheduleTime);
    }

    public void executeTask() {
        long currentTime = System.currentTimeMillis();
        System.out.println("Task " + ": schedule_start_time=" + scheduleTime + ",real start time="
                + currentTime + ",delay=" + (currentTime - scheduleTime));
        try {
            Thread.sleep(taskCost);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
