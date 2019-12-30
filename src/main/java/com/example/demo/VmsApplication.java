package com.example.demo;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class VmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmsApplication.class, args);
	}
@Bean(name="asyncExecutor") 
public Executor asyncExecutor() {
	ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();
	executor.setCorePoolSize(3);
	executor.setMaxPoolSize(3);
	executor.setQueueCapacity(500);
	executor.setThreadNamePrefix("JDAsync");
	executor.initialize();
	return executor;
}
}
