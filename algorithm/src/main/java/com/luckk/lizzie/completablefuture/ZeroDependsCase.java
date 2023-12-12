package com.luckk.lizzie.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author liukun.inspire
 * @Date 2023/10/7 16:11
 * @PackageName: com.luckk.lizzie.completablefuture
 * @ClassName: ZeroDependsCase
 * @Version 1.0
 */
public class ZeroDependsCase {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
// 1、使用runAsync或supplyAsync发起异步调用
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            return "result1";
        }, executor);
// 2、CompletableFuture.completedFuture()直接创建一个已完成状态的CompletableFuture
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("result2");
// 3、先初始化一个未完成的CompletableFuture，然后通过complete()、completeExceptionally()，完成该CompletableFuture
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("success");
    }
}
