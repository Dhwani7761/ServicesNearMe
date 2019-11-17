package com.daiict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.model.Service;
import com.daiict.repo.ServiceRepo;


@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ServiceRepo serviceRepo;
	
	@PostMapping("/save")
	public Service newService(@RequestBody Service service)
	{
		return serviceRepo.save(service);
	}
}
