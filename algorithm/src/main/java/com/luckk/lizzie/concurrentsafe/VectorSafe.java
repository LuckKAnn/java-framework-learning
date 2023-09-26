package com.luckk.lizzie.concurrentsafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Author liukun.inspire
 * @Date 2023/9/21 11:52
 * @PackageName: com.luckk.lizzie.concurrentsafe
 * @ClassName: VectorSafe
 * @Version 1.0
 */
public class VectorSafe {

    // Not safe
    static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            vector.add(i);
        }
        Thread t1 = new Thread(() -> {
            Iterator<Integer> iterator = vector.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                vector.add(i);
            }
        });
        t1.start();
        t2.start();

    }
}
