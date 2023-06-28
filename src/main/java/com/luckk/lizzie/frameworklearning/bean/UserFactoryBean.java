package com.luckk.lizzie.frameworklearning.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author liukun.inspire
 * @Date 2023/6/6 18:44
 * @PackageName: com.luckk.lizzie.frameworklearning.bean
 * @ClassName: UserFactoryBean
 * @Version 1.0
 */
@Component
public class UserFactoryBean implements FactoryBean<UserDTO> {
    @Override
    public UserDTO getObject() throws Exception {
        return new UserDTO();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDTO.class;
    }
}
