package com.luckk.lizzie.frameworklearning.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2023/8/30 19:51
 * @PackageName: com.luckk.lizzie.frameworklearning
 * @ClassName: SimpleFactoryStrategy
 * @Version 1.0
 */
public abstract class SimpleFactoryStrategy<T, S extends Strategy<T>> implements InitializingBean, ApplicationContextAware {


    private Map<T, S> mp;

    private ApplicationContext applicationContext;

    protected abstract Class<S> getStrategyType();


    @Override
    public void afterPropertiesSet() throws Exception {

        Collection<S> values = applicationContext.getBeansOfType(getStrategyType()).values();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
