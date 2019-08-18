package com.example.anno.anno.main2;


import com.example.anno.anno.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(value = "com.example.anno.main2",
//        excludeFilters = {
//            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={RestController.class}),
////            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Service.class),
//        },
        useDefaultFilters = false,
        includeFilters = {
//            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class, Repository.class}),
//            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {PersonService.class}),
            @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        }

    )

public class MainConfig2 {

    /**
     *
     * 返回的类型是要在容器中注入的类型
     * bean的id就是方法名
     */
    @Bean(value = "testPerson")
    public Person person(){
        Person person = new Person();
        person.setName("无名之辈");
        person.setAge(18);
        return person;
    }

}
