package com.example.mvcblocknonblock.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean(name = "nonblockTaskExecutor")
    public Executor nonblockTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1); // 기본 스레드 수
        taskExecutor.setMaxPoolSize(1); // 최대 스레드 수
        taskExecutor.setQueueCapacity(1); // Queue 사이즈
        taskExecutor.setThreadNamePrefix("nonBlock Thread-");
        return taskExecutor;
    }
}
