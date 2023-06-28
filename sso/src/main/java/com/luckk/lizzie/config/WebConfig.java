package com.luckk.lizzie.config;

import com.luckk.lizzie.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 00:51
 * @PackageName: com.luckk.lizzie.config
 * @ClassName: WebConfig
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("tokenInterceptor")
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/order/**")
                .excludePathPatterns("/login/**");

    }
}
