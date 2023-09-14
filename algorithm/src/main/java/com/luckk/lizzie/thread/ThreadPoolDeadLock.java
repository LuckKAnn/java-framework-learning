package com.luckk.lizzie.thread;

import java.util.concurrent.*;

/**
 * @Author liukun.inspire
 * @Date 2023/7/8 12:18
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: ThreadPoolDeadLock
 * @Version 1.0
 */
public class ThreadPoolDeadLock {

    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws InterruptedException {
        executorService.submit(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                executorService.submit(()->{
                }).get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

            System.out.println("执行完成");
        });
        executorService.submit(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Future<?> submit = executorService.submit(() -> {

            });
            try {
                submit.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行完成");
        });

        Thread.sleep(200000);
    }

}
