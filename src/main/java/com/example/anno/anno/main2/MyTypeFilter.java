package com.example.anno.anno.main2;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {

    /**
     * metadataReader 扫描到的当前类 the metadata reader for the target class
     * metadataReaderFactory 可以获取到其他类信息的工厂
     */

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //annotationMetadata 获取到当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取到当前类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //当前类的类名
        String className = classMetadata.getClassName();
        System.out.println("当前类的类名:"+className);

        //获取到当前类的资源信息，比如 路径等
        Resource resource = metadataReader.getResource();
        return true;
    }
}
