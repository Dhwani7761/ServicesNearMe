package com.daiict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.model.Customer;
import com.daiict.repo.CustomerRepo;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepo custRepo;
	
	@PostMapping("/save")
	public Customer newCustomer(@RequestBody Customer cust)
	{
		return custRepo.save(cust);
	}
	@PostMapping("/login")
	public String findCustomer(@RequestParam String email,@RequestParam String password,Customer c)
	{
		Customer cust = this.custRepo.findByEmail(email);
		if(cust.getPassword().equals(password))
		{
			return "login successful";
		}
		else
		{
			return "INvalid";
		}
	}
	@PostMapping("/updateAddress")
	public Customer changeAddress(@RequestBody Customer cust)
	{
		Customer c = this.custRepo.findByEmail(cust.getEmail());
		c.setArea(cust.getArea());
		c.setLandmark(cust.getLandmark());
		c.setAddress(cust.getAddress());
		c.setPincode(cust.getPincode());
		this.custRepo.save(c);
		return c;
	}
}
