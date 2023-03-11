package com.luckk.lizzie.frameworklearning;

import com.luckk.lizzie.frameworklearning.utils.SnowFlakeMaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameworkLearningApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(FrameworkLearningApplication.class, args);

		for (int i = 0; i < 10000000; i++) {
			Thread.sleep(100);
			new SnowFlakeMaker();
		}
	}

}
