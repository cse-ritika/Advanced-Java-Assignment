package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine {

	public DieselEngine() {
		System.out.println("Diesel Engine bean created");
	}

	public String getEngine() {
		return "Diesel Engine";
	}
}