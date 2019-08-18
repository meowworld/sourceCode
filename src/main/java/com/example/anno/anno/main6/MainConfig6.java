package com.example.anno.anno.main6;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"com.example.anno.main6","com.example.anno.main6"})
public class MainConfig6 {

    @Bean
    public ColorService colorService(){
        ColorService colorService = new ColorService();
        colorService.setLable("002");
        return colorService;
    }

}
