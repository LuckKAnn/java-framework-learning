package com.luckk.lizzie.oom;

/**
 * @Author liukun.inspire
 * @Date 2023/9/14 13:58
 * @PackageName: com.luckk.lizzie.oom
 * @ClassName: OutOfMemory01
 * @Version 1.0
 */
public class OutOfMemory01 {


    public static void main(String[] args) {
        while (true){
            new Thread(()->{
                while (true){

                }
            }).start();
        }

    }
}
