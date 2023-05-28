package com.luckk.lizzie;

import java.util.concurrent.TimeUnit;

/**
 *  close hook
 * @Author liukun.inspire
 * @Date 2023/5/17 00:16
 * @PackageName: com.luckk.lizzie
 * @ClassName: CloseHook
 * @Version 1.0
 */
public class CloseHook {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("call hook ,say goodbye");
        }));
        TimeUnit.SECONDS.sleep(10);
        // System.exit(1);


    }
}
