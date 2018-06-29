package com.zlg.springboot.demo001.demo001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class Demo001Application {

	/*1@value方式获得properties里的属性*/
	@Value("${book.author}")
	private String bookAuthor;
	@Value( "${book.name}" )
	private String bookName;

    /*2通过@ConfigutationProperties注解的类型安全的配置Bean的方式来获得规定前缀的所有属性*/
    @Autowired
	private TypeSafeBeanAuthorSettings authorSettings;

	@RequestMapping("/")
	private String  index(){
//		return "Hello Spring Boot! ---getPropertyInfo---By@Value :  ["+bookAuthor+"] and bookname=["+bookName+"]";//1
		return "Hello Spring Boot! ---getPropertyInfo---By@Value :  ["+authorSettings.getName()+"] and age=["+authorSettings.getAge()+"]";//2
	}

	@Autowired
	private HelloService helloService;
	@RequestMapping("/hello")
	private String hello(){
		return helloService.sayHello();
	}
	public static void main(String[] args) {
		SpringApplication.run(Demo001Application.class, args);
	}
}
