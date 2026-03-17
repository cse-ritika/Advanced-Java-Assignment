package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.client.DoctorClient;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentProducer;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentProducer producer;

    @PostMapping
    public String createAppointment(@RequestBody Appointment appointment) {
        // Validate doctor exists before sending to queue
        Doctor doctor = doctorClient.getDoctor(appointment.getDoctorId());
        if (doctor == null || !doctor.isAvailable()) {
            return "Doctor not available or not found!";
        }
        producer.sendAppointment(appointment);
        return "Appointment created!";
    }

    @GetMapping
    public List<Appointment> getAll() {
        return repository.findAll();
    }
}