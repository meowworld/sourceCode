package com.example.anno.anno.mian7;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * 切换数据源
 */

//todo:写在class上，只有在当前环境下，才会注册

@ConfigurationProperties(prefix = "spring.datasource")
@Configuration
@PropertySource("classpath:/car.properties")
public class MainConfig7 implements EmbeddedValueResolverAware {

    private StringValueResolver valueResolver;
    private String driverClassNmae;


    @Profile("test")
    @Bean("dataSourceTest")
    public DataSource dataSourceTest(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        String url = valueResolver.resolveStringValue("${url}");
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClassName(driverClassNmae);
        return dataSource;
    }

    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/xxl_job?characterEncoding=UTF-8&useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setDriverClassName(driverClassNmae);
        return dataSource;
    }
    @Profile("prod")
    @Bean("dataSourceProd")
    public DataSource dataSourceProd(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setDriverClassName(driverClassNmae);
        return dataSource;
    }

    //todo:写在bean上，只有在当前环境下，才会注册
    @Profile("test")
    @Bean
    public People people(){
        return new People();
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        driverClassNmae= valueResolver.resolveStringValue("${driver-class-name}");
    }
}
