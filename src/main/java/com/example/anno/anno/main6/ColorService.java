package com.example.anno.anno.main6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class ColorService implements BeanNameAware , ApplicationContextAware {

    private String lable= "001";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "ColorService{" +
                "lable='" + lable + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("beanName"+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println();
    }
}
