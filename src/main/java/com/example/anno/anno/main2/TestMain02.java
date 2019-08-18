package com.example.anno.anno.main2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class TestMain02 {
    public static void main(String[] args) {

        //todo: @ComponentSacn 注解的学习
        //注解式的容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(beanDefinition->{
            System.out.println("beanDefinition-->"+beanDefinition);
        });


    }
}
