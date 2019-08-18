package com.example.anno.anno.main4;


import com.example.anno.anno.domain.Red;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({Red.class})
@Configuration
public class MainConfig4 {

    @Bean
    public ColorFactoryBean colorFactoryBean(){
       return new ColorFactoryBean();
    }
}
