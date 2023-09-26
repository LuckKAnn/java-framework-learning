package com.luckk.lizzie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author liukun.inspire
 * @Date 2023/9/24 13:55
 * @PackageName: com.luckk.lizzie.Controller
 * @ClassName: HelloController
 * @Version 1.0
 */
@RestController

public class HelloController {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/hello")
    public String sayHello(){
        return" heelo liizie";
    }

    @RequestMapping("/hello/redis")
    public String sayHelloToRedis(){
        redisTemplate.opsForValue().set("helelo", "h2",10, TimeUnit.SECONDS);

        String helelo = redisTemplate.opsForValue().get("helelo");
        return helelo;
    }
}
