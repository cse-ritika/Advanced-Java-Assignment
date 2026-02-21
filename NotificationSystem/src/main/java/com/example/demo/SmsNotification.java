package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("smsBean")
@Lazy
public class SmsNotification implements Notification{
	SmsNotification(){
		System.out.println("SmsNotification bean created");
	}
	@Override
	public void send(String message) {
		System.out.println("SMS Notification sent: " + message);
	}
}
