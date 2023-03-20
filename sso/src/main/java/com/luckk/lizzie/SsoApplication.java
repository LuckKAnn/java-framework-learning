package com.luckk.lizzie;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author liukun.inspire
 * @Date 2023/3/19 21:54
 * @PackageName:com.luckk.lizzie
 * @ClassName: SsoApplication
 * @Version 1.0
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class);

        // Jedis jedis = new Jedis("172.16.0.0",6379);
        // jedis.set("lkk","jlj");
        // System.out.println(jedis.get("lkk"));




    }
}
