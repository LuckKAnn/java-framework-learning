package com.luckk.lizzie.config;

import com.luckk.lizzie.service.TestService;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 20:50
 * @PackageName: com.luckk.lizzie.config
 * @ClassName: TestServiceAutoConfiguration
 * @Version 1.0
 */
public class TestServiceAutoConfiguration implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{TestService.class.getName()};
    }
}
