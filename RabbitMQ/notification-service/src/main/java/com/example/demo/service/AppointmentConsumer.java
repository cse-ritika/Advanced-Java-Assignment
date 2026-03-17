package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;

@Service
public class AppointmentConsumer {

    @RabbitListener(queues = "appointment-queue")
    public void consumeAppointmentEvent(Appointment event) {

        System.out.println("Received appointment event!");

        System.out.println("Doctor ID: "     + event.getDoctorId());
        System.out.println("Patient Name: "  + event.getPatientName());
        System.out.println("Date: "          + event.getDate());

        System.out.println("Sending Appointment Confirmation to: "
                + event.getPatientName());
    }
}