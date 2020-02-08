package com.farazdurrani.dynamicschedular;

import java.time.Duration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
		for (int i = 0; i < 3; i++) {
			ts.scheduleAtFixedRate(new MyRunnable("Task"+i),
				Duration.ofMillis(3000));
		}
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler ts = new ThreadPoolTaskScheduler();
		ts.setPoolSize(3);
		return ts;
	}
	
	@Scheduled(initialDelay = 30000, fixedRate = 30000)
	public void task() {
		System.out.println("Task 'Scheduled' Running in Thread ID: " + Thread.currentThread().getId());
	}

}
