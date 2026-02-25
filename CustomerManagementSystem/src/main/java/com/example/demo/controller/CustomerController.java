package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {

    private CustomerService customerservice;

    public CustomerController(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    // Show Add Form
    @GetMapping("/addCustomer")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    // Save Customer
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerservice.saveCustomer(customer);
        return "redirect:/customers";
    }

    // View Customers
    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        model.addAttribute("customers",
                customerservice.getAllCustomer());
        return "customers";
    }
}