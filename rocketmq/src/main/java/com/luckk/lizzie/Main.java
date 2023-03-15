package com.luckk.lizzie;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author liukun.inspire
 * @Date ${DATE} ${TIME}
 * @PackageName:com.luckk.lizzie
 * @ClassName: ${NAME}
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.remove(new Integer(1));
        list.size();
        System.out.println("Hello world!");
    }
}