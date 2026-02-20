package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(TestApplication.class, args);
//		System.out.println("Hello world");
//		Car car1=context.getBean(Car.class);
//		Car car2=context.getBean(Car.class);
//		System.out.println(car1);
//		System.out.println(car2);
		
		Vehicle v = context.getBean(Car.class);
		v.run();
	}

}    