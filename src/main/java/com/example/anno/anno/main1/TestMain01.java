package com.example.anno.anno.main1;

import com.example.anno.anno.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class TestMain01 {
    public static void main(String[] args) {

        //todo: @Configuration & @Bean 注解

        //注解式的容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        Person bean = applicationContext.getBean(Person.class);

        System.out.println(bean);

        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Person.class);

        Arrays.asList(beanDefinitionNames).forEach(beanName->{
            System.out.println("beanName:-->"+beanName);
        });
    }
}
