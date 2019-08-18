package com.example.anno.anno.main4;

import com.example.anno.anno.domain.Yellow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinition implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        boolean blue = registry.containsBeanDefinition("blue");
        RootBeanDefinition yellowBeanDefinition = new RootBeanDefinition(Yellow.class);
        //手动注册bean到容器中
        registry.registerBeanDefinition("yellow", yellowBeanDefinition);
    }
}
