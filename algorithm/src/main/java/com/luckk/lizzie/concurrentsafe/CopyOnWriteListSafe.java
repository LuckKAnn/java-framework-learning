package com.luckk.lizzie.concurrentsafe;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author liukun.inspire
 * @Date 2023/9/21 11:52
 * @PackageName: com.luckk.lizzie.concurrentsafe
 * @ClassName: CopyOnWriteListSafe
 * @Version 1.0
 */
public class CopyOnWriteListSafe {
    //  safe
    static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    static Iterator<Integer> iterator ;

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        iterator = list.iterator();
        // 快照版本
        list.add(-1);
        Thread t1 = new Thread(() -> {
            // Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        });
        t1.start();
        t2.start();

    }
}
