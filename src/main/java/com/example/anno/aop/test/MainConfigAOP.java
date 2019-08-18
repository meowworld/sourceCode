package com.example.anno.aop.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {

    //todo: 开启基于注解的aop @EnableAspectJAutoProxy

    //将切面类注入到容器中
    @Bean
    public TestCal testCal(){
        return new TestCal();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }



}
