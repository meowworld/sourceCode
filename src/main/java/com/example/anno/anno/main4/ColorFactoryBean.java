package com.example.anno.anno.main4;

import com.example.anno.anno.domain.Color;
import org.springframework.beans.factory.FactoryBean;

//创建一个spring定义的工厂bean
public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        //创建一个color实例
        System.out.println("ColorFactoryBean-->getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        //返回color的类class
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        //单实例
        return true;
    }
}
