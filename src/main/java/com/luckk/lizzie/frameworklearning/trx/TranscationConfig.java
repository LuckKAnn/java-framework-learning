package com.luckk.lizzie.frameworklearning.trx;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author liukun.inspire
 * @Date 2023/5/20 10:26
 * @PackageName: com.luckk.lizzie.frameworklearning.trx
 * @ClassName: TranscationConfig
 * @Version 1.0
 */
@ComponentScan
@EnableTransactionManagement

public class TranscationConfig {


    @Transactional
    public  void test(){

        ReentrantLock reentrantLock = new ReentrantLock();

    }
}
