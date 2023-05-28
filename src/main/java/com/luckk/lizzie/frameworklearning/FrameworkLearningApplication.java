package com.luckk.lizzie.frameworklearning;

import com.luckk.lizzie.frameworklearning.service.AopService;
import com.luckk.lizzie.frameworklearning.utils.SnowFlakeMaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Random;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
public class FrameworkLearningApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(FrameworkLearningApplication.class, args);

		AopService bean = applicationContext.getBean(AopService.class);
		System.out.println(bean);
		bean.methodB();
		bean.methodA();

		String s = "";
		String[] split = s.split("");



	}

}
