package com.example.anno.anno.main3;

import com.example.anno.anno.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class TestMain03 {
    public static void main(String[] args) {

        //todo: @ComponentSacn 注解的学习
        //注解式的容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);

        System.out.println(beansOfType);
    }
}
