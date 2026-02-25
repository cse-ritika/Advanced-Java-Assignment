package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	public CustomerRepository customerrepo;
	
	public CustomerService(CustomerRepository customerrepo) {
		this.customerrepo=customerrepo;
	}
	public List<Customer> getAllCustomer(){
		return customerrepo.findAll();
	}
	public  Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerrepo.save(customer);
	}
} 
 