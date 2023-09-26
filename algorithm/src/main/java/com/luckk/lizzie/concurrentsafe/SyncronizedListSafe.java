package com.luckk.lizzie.concurrentsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author liukun.inspire
 * @Date 2023/9/21 11:56
 * @PackageName: com.luckk.lizzie.concurrentsafe
 * @ClassName: SyncronizedListSafe
 * @Version 1.0
 */
public class SyncronizedListSafe {

    // not safe
    static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        Thread t1 = new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
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
