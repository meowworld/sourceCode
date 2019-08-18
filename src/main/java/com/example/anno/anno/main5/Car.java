package com.example.anno.anno.main5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @see {@link InitializingBean} 初始化后置方法
 * @see {@link DisposableBean} 初始化后置方法
 */

public class Car implements ApplicationContextAware {

    @Value("${name}")
    private String name;

    private ApplicationContext applicationContext;

    public Car() {
        System.out.println(" -- car constructor ---- ");
    }

    @PostConstruct
    public void construct(){
        System.out.println(" 初始化完后的，@PostConstruct");
    }

    @PreDestroy
    public void destroy(){
        System.out.println(" 销毁之前的回调方法，@PreDestroy");
    }

    public void initMethod(){
        System.out.println("----- 初始化之后 initMethod----");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
