package com.luckk.lizzie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 17:01
 * @PackageName: com.luckk.lizzie
 * @ClassName: BuyerCartApplication
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class BuyerCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuyerCartApplication.class);

        /**
         *
         * https://juejin.cn/post/6844903597675642887
         * 实现思路:
         *  如果没有登陆，那么放到cookie里面返回
         *  查询购物车信息的接口，先从cookie拿，如果登陆了，再从redis拿
         *  添加购物车，先从cookie拿，先构造购物车的对象，如果登陆了，删除cookie，并且上传redis
         *  新增一个假如购物车的方法
         */
    }
}
