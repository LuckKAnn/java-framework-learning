package com.luckk.lizzie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author liukun.inspire
 * @Date 2023/6/1 23:01
 * @PackageName: com.luckk.lizzie
 * @ClassName: SecuritySSOApplication
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SecuritySSOApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritySSOApplication.class);
    }
}
