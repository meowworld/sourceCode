package com.example.anno.anno.main3;


import com.example.anno.anno.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig3 {

    /**
     *
     * 返回的类型是要在容器中注入的类型
     * bean的id就是方法名
     */
    @Bean("billGate")
    public Person person1(){
        System.out.println("给容器中添加person");
        Person person = new Person();
        person.setName("billGate");
        person.setAge(18);
        return person;
    }

    @Bean("linux")
    @Conditional({MyPersonConditionLinux.class})
    public Person person2(){
        System.out.println("给容器中添加person");
        Person person = new Person();
        person.setName("linux");
        person.setAge(18);
        return person;
    }

    @Bean("meow")
    @Conditional({MyPersonConditionWin.class})
    public Person person3(){
        System.out.println("给容器中添加person");
        Person person = new Person();
        person.setName("meow");
        person.setAge(18);
        return person;
    }
}
