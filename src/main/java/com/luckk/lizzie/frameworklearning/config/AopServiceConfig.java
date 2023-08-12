package com.luckk.lizzie.frameworklearning.config;

import com.luckk.lizzie.frameworklearning.service.AopService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liukun.inspire
 * @Date 2023/7/1 14:50
 * @PackageName: com.luckk.lizzie.frameworklearning.config
 * @ClassName: AopServiceConfig
 * @Version 1.0
 */
@Configuration
public class AopServiceConfig {
    @Bean
    public AopService aopService1111(){
        AopService aopService = new AopService();
        System.out.println(aopService);
        return aopService;
    }
}
