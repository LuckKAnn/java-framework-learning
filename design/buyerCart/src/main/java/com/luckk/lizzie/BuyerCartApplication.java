package com.luckk.lizzie;

import com.luckk.lizzie.config.EnableTestAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.concurrent.CompletableFuture;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 17:01
 * @PackageName: com.luckk.lizzie
 * @ClassName: BuyerCartApplication
 * @Version 1.0
 */
@EnableTestAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class BuyerCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuyerCartApplication.class);

        /**
         *
         * https://juejin.cn/post/6844903597675642887
         * https://ynfatal.github.io/2019/08/17/SpringBoot2/SpringBoot2%E7%AC%AC%E4%BA%8C%E5%8D%81%E4%B9%9D%E7%AF%87Redis%E5%AE%9E%E7%8E%B0%E8%B4%AD%E7%89%A9%E8%BD%A6/
         * 实现思路:
         *  如果没有登陆，那么放到cookie里面返回
         *  查询购物车信息的接口，先从cookie拿，如果登陆了，再从redis拿
         *  添加购物车，先从cookie拿，先构造购物车的对象，如果登陆了，删除cookie，并且上传redis
         *  新增一个假如购物车的方法
         */


        /**
         * 继续深化，商品SKU的信息放到其它的key里面，到时候去根据SKU来获取。
         * 这里面没有加商品的时间，那么怎么根据时间动态排序呢
         * 没有购物车事项的增加和删除
         */


    }
}
