package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService empservice;

    // Constructor Injection
    public EmployeeController(EmployeeService empservice) {
        this.empservice = empservice;
    }

    // Show All Employees
    @GetMapping("/employees")
    public String getEmployeeDetails(Model model) {
        List<Employee> employees = empservice.getAllEmployee();
        model.addAttribute("employees", employees);  // consistent name
        return "employee";
    }

    // Show Add Form
    @GetMapping("/addEmployee")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    // Save Employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee emp) {
        empservice.saveEmployee(emp);
        return "redirect:/employees";
    }
}