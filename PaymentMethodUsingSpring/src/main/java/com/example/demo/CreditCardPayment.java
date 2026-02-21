package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")      
@Primary                
public class CreditCardPayment implements Payment {

    public CreditCardPayment() {
        System.out.println("CreditCardPayment Bean Created");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Credit Card payment of Rs. " + amount + " successful");
    }

    @PostConstruct
    public void init() {
        System.out.println("CreditCardPayment Bean Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CreditCardPayment Bean Destroyed");
    }
}