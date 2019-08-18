package com.example.anno.anno.main1;


import com.example.anno.anno.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MainConfig {

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
