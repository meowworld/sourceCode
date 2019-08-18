package com.example.anno.anno.main5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainLifeCycle {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigLifecycle.class);

        Car bean = applicationContext.getBean(Car.class);

        System.out.println(bean);

        applicationContext.close();
    }
}
