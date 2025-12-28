package com.yogashree.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		// create an object of the IoC which is of type ApplicationContext
		ApplicationContext context=SpringApplication.run(MyAppApplication.class, args);

		Dev obj=context.getBean(Dev.class); // Dependency Injection

		obj.depInject();

	}

}
