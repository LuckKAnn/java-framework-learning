package com.luckk.lizzie.frameworklearning.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author liukun.inspire
 * @Date 2023/3/17 12:44
 * @PackageName:com.luckk.lizzie.frameworklearning.service
 * @ClassName: AopService
 * @Version 1.0
 */
// @Service

@Component
public class AopService {


    // @Autowired
    // OrderService orderService;
    // // @Async


    public void methodA() {
        System.out.println("11111");
    }

    public void methodB() {
        System.out.println("bbbb");
    }


}
