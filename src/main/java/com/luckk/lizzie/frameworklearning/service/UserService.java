package com.luckk.lizzie.frameworklearning.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @Author liukun.inspire
 * @Date 2023/6/23 20:53
 * @PackageName: com.luckk.lizzie.frameworklearning.service
 * @ClassName: UserService
 * @Version 1.0
 */
@Service
// @DependsOn("orderService")
public class UserService {

    // @Autowired
    // AopService aopService;
    //
    // public AopService getAopService() {
    //     return aopService;
    // }

    // @Autowired
    // @Lazy
    // private OrderService orderSonService;
    // // public UserService(OrderService orderService) {
    // //     this.orderService = orderService;
    // // }
    //
    // public OrderService getOrderService(){
    //     System.out.println(orderSonService);
    //     orderSonService.sayHello();
    //     System.out.println(orderSonService);
    //     return orderSonService;
    //
    // }
}
