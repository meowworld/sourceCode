package com.example.anno.anno.main4;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportSelector implements ImportSelector {
    /**
     * @param importingClassMetadata 当前标注@Import 注解的类的所有信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /*Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        annotationTypes.forEach(className->{
            System.out.println("MyImportSelector-->"+className);
        });*/
        return new String[]{"com.example.anno.domain.Blue"};
    }
}
