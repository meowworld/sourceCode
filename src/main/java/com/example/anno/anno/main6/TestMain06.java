package com.example.anno.anno.main6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class TestMain06 {
    public static void main(String[] args) {

        //todo:自动装配
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig6.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).forEach(beanName->{
            System.out.println(beanName);
        });

        ColorController bean = applicationContext.getBean(ColorController.class);
        System.out.println(bean);




    }
}
