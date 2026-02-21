package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NotificationSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NotificationSystemApplication.class, args);
		
		Notification email = context.getBean("emailBean",Notification.class);
		email.send("Welcome via email!!");
		
		System.out.println();
		
		Notification sms = context.getBean("smsBean",Notification.class);
		sms.send("Welcome via sms!!");
	}
}
