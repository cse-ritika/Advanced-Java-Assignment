package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class PaymentMethodUsingSpringApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(PaymentMethodUsingSpringApplication.class, args);

        Payment payment = context.getBean(Payment.class);
        payment.pay(5000);

        System.out.println("------------------------");

        UpiPayment upi1 = context.getBean(UpiPayment.class);
        upi1.pay(1000);

        UpiPayment upi2 = context.getBean(UpiPayment.class);
        upi2.pay(2000);

        System.out.println("Are both UPI beans same? " + (upi1 == upi2));
    }
} 