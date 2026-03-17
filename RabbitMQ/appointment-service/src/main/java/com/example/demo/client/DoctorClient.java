package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Doctor;

@FeignClient(name="doctor-service")
public interface DoctorClient {

    @GetMapping("/doctors/{id}")
    Doctor getDoctor(@PathVariable Long id);
}
