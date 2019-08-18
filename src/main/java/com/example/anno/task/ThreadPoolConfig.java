package com.example.anno.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService logThreadPool(){
        ExecutorService logThreadPool = Executors.newCachedThreadPool();
        return logThreadPool;
    }

}
