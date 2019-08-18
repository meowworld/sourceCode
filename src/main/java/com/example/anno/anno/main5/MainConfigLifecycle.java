package com.example.anno.anno.main5;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = "car.properties")
@Configuration
@ComponentScan(value = "com.example.anno.main5")
public class MainConfigLifecycle {

    @Bean(initMethod = "initMethod")
    public Car car(){
        Car car = new Car();
        return car;
    }

}
