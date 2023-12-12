package com.luckk.lizzie.paint;

/**
 * CPU 绘画，50%的利用率
 *
 * @Author liukun.inspire
 * @Date 2023/12/12 17:27
 * @PackageName: com.luckk.lizzie.paint
 * @ClassName: CpuPaint50
 * @Version 1.0
 */
public class CpuPaint50 {

    public static void doPaint() throws InterruptedException {
        long busyTime = 10, idleTime = busyTime;
        while (true) {
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) <= busyTime) ;
            Thread.sleep(idleTime);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int availableProcessorNums = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < availableProcessorNums; i++) {
            new Thread(() -> {
                try {
                    doPaint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }
}
