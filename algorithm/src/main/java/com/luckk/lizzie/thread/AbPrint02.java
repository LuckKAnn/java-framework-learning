package com.luckk.lizzie.thread;

/**
 * @Author liukun.inspire
 * @Date 2023/3/14 17:29
 * @PackageName:com.luckk.lizzie.thread
 * @ClassName: AbPrint02
 * @Version 1.0
 */
public class AbPrint02 {

    /**
     * 这种方案用flag来决定，应该到哪个线程打印，如果有100个线程交替打印，无需去申请多个锁
     * 注意的几个点：
     * - 不加volatile可以吗，似乎是可以的，sync保证了更改的刷新和读入
     * - 注意一定要用while来防止虚假唤醒
     */
    private static  int flag = 0;
    static final Object object = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    while (flag == 0) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.printf("~");
                    flag = 0;
                    object.notifyAll();
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    while (flag == 1) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.printf("a");
                    flag = 1;
                    object.notifyAll();
                }
            }
        }, "t2");


        t1.start();
        t2.start();

    }
}
