package com.luckk.lizzie.frameworklearning.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author liukun.inspire
 * @Date 2023/6/1 13:57
 * @PackageName: com.luckk.lizzie.frameworklearning.service
 * @ClassName: AopServiceFactoryBean
 * @Version 1.0
 */
// @Component
public class AopServiceFactoryBean implements FactoryBean<AopService> {
    @Override
    public AopService getObject() throws Exception {
        return new AopService();
    }

    @Override
    public Class<?> getObjectType() {
        return AopService.class;
    }
}
