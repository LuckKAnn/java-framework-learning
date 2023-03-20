package com.luckk.lizzie.frameworklearning.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author liukun.inspire
 * @Date 2023/3/17 12:44
 * @PackageName:com.luckk.lizzie.frameworklearning.service
 * @ClassName: AopService
 * @Version 1.0
 */
@Service
public class AopService {

    @Async
    public void methodA(){
        System.out.println("11111");
    }

    public void methodB(){
        System.out.println("bbbb");
    }
}
