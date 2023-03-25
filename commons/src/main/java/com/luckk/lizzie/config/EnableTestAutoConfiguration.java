package com.luckk.lizzie.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 20:54
 * @PackageName: com.luckk.lizzie.config
 * @ClassName: EnableTestAutoConfiguration
 * @Version 1.0
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(TestServiceAutoConfiguration.class)
public @interface EnableTestAutoConfiguration {


}
