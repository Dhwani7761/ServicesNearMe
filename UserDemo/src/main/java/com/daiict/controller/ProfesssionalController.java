package com.daiict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.model.Professional;
import com.daiict.repo.ProfessionalRepo;


@RestController
@RequestMapping("/professional")
public class ProfesssionalController {
	
	@Autowired
	private ProfessionalRepo profRepo;
	
	@PostMapping("/save")
	public Professional newProfessional(@RequestBody Professional prof)
	{
		return profRepo.save(prof);
	}
	@PostMapping("/login")
	public String findCustomer(@RequestParam String email,@RequestParam String password,Professional c)
	{
		Professional cust = this.profRepo.findByEmail(email);
		if(cust.getPassword().equals(password))
		{
			return "login successful";
		}
		else
		{
			return "INvalid";
		}
	}
}
