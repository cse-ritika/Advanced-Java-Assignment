package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repo;

    @GetMapping
    public List<Doctor> getDoctors(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return repo.save(doctor);
    }

}
