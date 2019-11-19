package com.daiict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.model.CreateProfessional;
import com.daiict.model.Professional;
import com.daiict.repo.ProfessionalRepo;
import com.daiict.repo.ServiceRepo;


@RestController
@RequestMapping("/professional")
public class ProfesssionalController {
	
	@Autowired
	private ProfessionalRepo profRepo;
	
	@Autowired
	private ServiceRepo serviceRepo;
	
	@PostMapping("/save")
	public Professional newProfessional(@RequestBody CreateProfessional prof)
	{
		Professional p = new Professional();
		p.setAreaOfExpertise(prof.getAreaOfExpertise());
		p.setEmail(prof.getEmail());
		p.setFirstname(prof.getFirstname());
		p.setLastname(prof.getLastname());
		p.setPassword(prof.getPassword());
		p.setService(serviceRepo.getOne(prof.getSid()));
		return profRepo.save(p);
		
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
