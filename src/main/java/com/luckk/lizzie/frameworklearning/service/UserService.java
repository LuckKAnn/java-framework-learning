package com.luckk.lizzie.frameworklearning.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
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


    @Autowired
    private OrderService orderService;
    // public UserService(OrderService orderService) {
    //     this.orderService = orderService;
    // }

    public OrderService getOrderService(){
        return orderService;
    }
}
