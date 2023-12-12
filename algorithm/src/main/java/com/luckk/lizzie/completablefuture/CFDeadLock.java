package com.luckk.lizzie.completablefuture;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author liukun.inspire
 * @Date 2023/10/7 17:04
 * @PackageName: com.luckk.lizzie.completablefuture
 * @ClassName: CFDeadLock
 * @Version 1.0
 */
public class CFDeadLock {
    ExecutorService threadPool1 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
    public Object doGet() {
        CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {

            return CompletableFuture.supplyAsync(() -> {
                System.out.println("child");
                return "child";
            }, threadPool1).join();// 子任务
        }, threadPool1);
        return cf1.join();
    }

    public static void main(String[] args) {
        CFDeadLock cfDeadLock = new CFDeadLock();
        for (int i = 0; i < 100000; i++) {
            cfDeadLock.doGet();
        }
    }
}
