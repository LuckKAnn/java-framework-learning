package com.luckk.lizzie.thread.ab;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author liukun.inspire
 * @Date 2023/7/6 23:37
 * @PackageName: com.luckk.lizzie.thread.ab
 * @ClassName: ABPrintNew
 * @Version 1.0
 */
public class ABPrintNew {


    private static Semaphore aSemaphore = new Semaphore(1);

    private static Semaphore bSemaphore = new Semaphore(0);

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
          while (true){
              try {
                  aSemaphore.acquire();
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }

              atomicInteger.incrementAndGet();
              System.out.printf("a");
              if (atomicInteger.get() == 2) {
                  bSemaphore.release();
                  Thread.currentThread().stop();
              }
              bSemaphore.release();
          }
        }, "ta");


        Thread t2 = new Thread(() -> {
            while (true){
                try {
                    bSemaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.printf("b");
                if (atomicInteger.get() == 2) {
                    Thread.currentThread().stop();
                }
                aSemaphore.release();
            }
        }, "ta");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        // countDownLatch.await();

    }

}
