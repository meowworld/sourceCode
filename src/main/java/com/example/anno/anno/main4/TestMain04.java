package com.example.anno.anno.main4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class TestMain04 {
    public static void main(String[] args) throws Exception {

        //todo: @Import 注解，给容器导入第三方bean

        //注解式的容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig4.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).forEach(beanName ->{
            System.out.println(beanName);
        });

        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println("colorFactoryBeanClass-->"+colorFactoryBean.getClass());

        //获取FactoryBean 本身，加一个前缀& @see BeanFactory : String FACTORY_BEAN_PREFIX = "&";
        Object colorFactoryBean1 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean1.getClass());

    }
}
