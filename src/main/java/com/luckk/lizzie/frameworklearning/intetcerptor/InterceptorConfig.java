package com.luckk.lizzie.frameworklearning.intetcerptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                // 对哪些资源起过滤作用
                .addPathPatterns("/**")
                // 对哪些资源起排除作用
                .excludePathPatterns("/loginUser", "/login.html", "/css/**", "/js/**", "/static/**");
    }
}
