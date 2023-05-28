package com.luckk.lizzie.jvm;

/**
 * @Author liukun.inspire
 * @Date 2023/3/29 11:01
 * @PackageName: com.luckk.lizzie.jvm
 * @ClassName: EscapeLock
 * @Version 1.0
 */

class Resource implements Runnable{

    @Override
    public void run() {
        Object o = new Object();
        synchronized (o){
            int i =1;
        }

    }
}

public class EscapeLock {

    public static void main(String[] args) {

        Thread thread = new Thread(new Resource());

        thread.start();
    }
}
