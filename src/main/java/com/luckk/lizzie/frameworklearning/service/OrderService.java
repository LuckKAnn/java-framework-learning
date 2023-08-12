package com.luckk.lizzie.frameworklearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author liukun.inspire
 * @Date 2023/6/1 13:58
 * @PackageName: com.luckk.lizzie.frameworklearning.service
 * @ClassName: OrderService
 * @Version 1.0
 */
// @DependsOn("userService")
@Service
public class OrderService {


    @Autowired
    AopService aopService;

    // public AopService getAopService() {
    //     return aopService;
    // }
    //
    // public void setAopService(AopService aopService) {
    //     this.aopService = aopService;
    // }

    // AopService aopService;
    //
    // @Resource(type =AopService.class)
    // public void setAopService1111(AopService aopService) {
    //     this.aopService = aopService;
    // }
    //
    // public void sayHello(){
    //     System.out.println("heelo");
    //     System.out.println(aopService);
    // }
}
