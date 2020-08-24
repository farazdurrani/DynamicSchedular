package com.farazdurrani.dynamicschedular2;

import java.time.Duration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@EnableScheduling
public class DynamicSchedularApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DynamicSchedularApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ThreadPoolTaskScheduler ts = threadPoolTaskScheduler();
		for (int i = 5; i < 8; i = i + 2) {
			ts.scheduleAtFixedRate(new MyRunnable("Task"+i, i),
				Duration.ofMillis(3000));
		}
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler ts = new ThreadPoolTaskScheduler();
		ts.setPoolSize(1);
		return ts;
	}
	
}
