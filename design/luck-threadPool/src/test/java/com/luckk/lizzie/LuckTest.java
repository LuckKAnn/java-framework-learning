package com.luckk.lizzie;


import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author liukun.inspire
 * @Date 2023/9/25 12:03
 * @PackageName: com.luckk.lizzie
 * @ClassName: LuckTest
 * @Version 1.0
 */
public class LuckTest {

    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        threadPoolExecutor.execute(()->{});


    }

}
