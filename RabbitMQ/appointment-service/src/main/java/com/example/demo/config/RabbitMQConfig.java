package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE   = "appointment-exchange";
    public static final String QUEUE      = "appointment-queue";
    public static final String ROUTING_KEY = "appointment.routing";

    @Bean
    public DirectExchange appointmentExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue appointmentQueue() {
        return new Queue(QUEUE, true); // durable = true
    }

    @Bean
    public Binding binding(Queue appointmentQueue, DirectExchange appointmentExchange) {
        return BindingBuilder
                .bind(appointmentQueue)
                .to(appointmentExchange)
                .with(ROUTING_KEY);
    }

    // Serialize objects as JSON instead of Java serialization
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}