package com.luckk.lizzie.thread.ab;

import java.util.concurrent.Semaphore;

/**
 * @Author liukun.inspire
 * @Date 2023/7/6 23:51
 * @PackageName: com.luckk.lizzie.thread.ab
 * @ClassName: AbTask
 * @Version 1.0
 */
public class AbTask implements Runnable{

    private Semaphore a;
    private Semaphore b;

    private String p;

    private int num = 0 ;

    public AbTask(Semaphore a, Semaphore b, String p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }

    @Override
    public void run() {

        while (num != 100){
            try {
                a.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf(p);
            num ++;
            b.release();
        }
    }
}
