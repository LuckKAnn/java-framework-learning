package com.luckk.lizzie.concurrentsafe;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2023/9/21 12:03
 * @PackageName: com.luckk.lizzie.concurrentsafe
 * @ClassName: HashMapiteratorSafe
 * @Version 1.0
 */
public class HashTableIteratorSafe {

    static Hashtable<Integer,Integer> mp = new Hashtable<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
           mp.put(i,i);
        }
        Thread t1 = new Thread(() -> {
            Iterator<Map.Entry<Integer, Integer>> iterator = mp.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 10000; i < 30000; i++) {
                mp.put(i,i);
            }
        });
        t1.start();
        t2.start();

    }




}
