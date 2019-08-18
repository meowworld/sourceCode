package com.example.anno.anno.mian7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

public class TestMain07 {
    public static void main(String[] args) {

        //todo: @Profile 注解
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setActiveProfiles("prod");
        applicationContext.register(MainConfig7.class);
        applicationContext.refresh();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(beanName->{
            System.out.println("beanName-->"+beanName);
        });
    }
}
