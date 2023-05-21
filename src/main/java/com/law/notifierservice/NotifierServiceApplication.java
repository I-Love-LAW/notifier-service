package com.law.notifierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class NotifierServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotifierServiceApplication.class, args);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = createThreadPoolTaskExecutor();
        configureExecutor(executor);
        return executor;
    }

    private ThreadPoolTaskExecutor createThreadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    private void configureExecutor(ThreadPoolTaskExecutor executor) {
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("LAW-");
        executor.initialize();
    }
}
