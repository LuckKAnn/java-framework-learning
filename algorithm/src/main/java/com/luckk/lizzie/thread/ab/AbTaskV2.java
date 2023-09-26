package com.luckk.lizzie.thread.ab;

import java.util.concurrent.Semaphore;

/**
 * @Author liukun.inspire
 * @Date 2023/7/8 17:10
 * @PackageName: com.luckk.lizzie.thread.ab
 * @ClassName: AbTaskV2
 * @Version 1.0
 */
public class AbTaskV2 {


    public static void main(String[] args) throws InterruptedException {
        ThreadPrintChar threadPrintChar = new ThreadPrintChar(50, 0);

        Thread a = new Thread(() -> threadPrintChar.doPrint(0, 1, "A"));
        a.start();
        Thread b = new Thread(() -> threadPrintChar.doPrint(1, 0, "B"));
        b.start();

        a.join();
        b.join();

    }


    public static class ThreadPrintChar {

        private int num;

        private int flag;

        public ThreadPrintChar(int num, int flag) {
            this.num = num;
            this.flag = flag;
        }

        public void doPrint(int runFlag, int nextFlag, String word) {
            for (int i = 0; i < num; i++) {
                synchronized (this) {
                    while (flag != runFlag) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(word);
                    flag = nextFlag;
                    this.notifyAll();
                }
            }
            System.out.println("end");

        }
    }
}
