package com.luckk.lizzie;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author liukun.inspire
 * @Date 2023/9/25 00:37
 * @PackageName: com.luckk.lizzie
 * @ClassName: LuckThreadPoolTest
 * @Version 1.0
 */
public class LuckThreadPoolTest {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        FutureTask< Integer> futureTask;
        LuckThreadPool luckThreadPool = new LuckThreadPool();
        for (int i = 0; i < 4; i++) {
            Thread.sleep(1000);
            luckThreadPool.execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("执行task" + atomicInteger.incrementAndGet());
            });
        }

    }
}
