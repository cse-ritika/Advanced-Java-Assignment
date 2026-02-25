package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    public EmployeeRepository emprepo;

    // Constructor Injection
    public EmployeeService(EmployeeRepository emprepo) {
        this.emprepo = emprepo;
    }

    // Get All Employees
    public List<Employee> getAllEmployee() {
        return emprepo.findAll();
    }

    // Save Employee
    public void saveEmployee(Employee emp) {
        emprepo.save(emp);
    }
}