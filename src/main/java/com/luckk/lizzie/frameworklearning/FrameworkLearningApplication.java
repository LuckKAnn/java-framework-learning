package com.luckk.lizzie.frameworklearning;

import com.luckk.lizzie.frameworklearning.bean.UserDTO;
import com.luckk.lizzie.frameworklearning.bean.UserFactoryBean;
import com.luckk.lizzie.frameworklearning.service.AopService;
import com.luckk.lizzie.frameworklearning.service.OrderSonService;
import com.luckk.lizzie.frameworklearning.service.UserService;
import com.luckk.lizzie.frameworklearning.utils.SnowFlakeMaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
public class FrameworkLearningApplication {

	public static void main(String[] args) throws InterruptedException, UnknownHostException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(FrameworkLearningApplication.class, args);
		OrderSonService bean1 = applicationContext.getBean(OrderSonService.class);
	}

}
