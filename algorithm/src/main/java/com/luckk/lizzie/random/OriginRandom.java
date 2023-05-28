package com.luckk.lizzie.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author liukun.inspire
 * @Date 2023/5/4 22:00
 * @PackageName: com.luckk.lizzie.random
 * @ClassName: OriginRandom
 * @Version 1.0
 */
public class OriginRandom {

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            Random random = new Random(121);
            System.out.println(random.nextInt());
            System.out.println(ThreadLocalRandom.current().nextInt());
        }, "A");

        Thread t2 = new Thread(() -> {
            Random random = new Random(121);
            System.out.println(random.nextInt());
            System.out.println(ThreadLocalRandom.current().nextInt());

        }, "B");

        t1.start();
        t2.start();
    }
}
