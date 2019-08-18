package com.example.anno;

import com.example.anno.anno.mian7.MainConfig7;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig7.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.asList(beanDefinitionNames).forEach(beanName->{
			System.out.println("beanName-->"+beanName);
		});

		DataSource bean = applicationContext.getBean(DataSource.class);

		System.out.println("HikariDataSource --> " +bean);

	}

}
