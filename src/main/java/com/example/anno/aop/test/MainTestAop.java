package com.example.anno.aop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTestAop {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAOP.class);

        //todo：自己new出来的对象不再Spring容器放入管理中，就不会有aop功能
        TestCal bean = applicationContext.getBean(TestCal.class);

        int cal = bean.cal(2, 0);

        applicationContext.close();
    }



}
