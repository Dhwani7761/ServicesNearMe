package com.daiict.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.model.Admin;
import com.daiict.repo.AdminRepo;
import com.daiict.repo.ServiceRepo;
import com.daiict.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	ServiceRepo serviceRepo;
	
	@Autowired
	AdminService adminService;

	@PostMapping("/save")
	public Admin newAdmin(@RequestBody Admin admin) {
		return adminRepo.save(admin);
	}

	@PostMapping("/login")
	public String findAdmin(@RequestParam String email, @RequestParam String password, Admin c) {
		Admin admin = this.adminRepo.findByEmail(email);
		if (admin.getPassword().equals(password)) {
			return "login successful";
		} else {
			return "Invalid";
		}
	}

	@PutMapping("/assignRequest/{rId}")
	public String assignRequest(@PathVariable long rId) {

		return adminService.updateService(rId);
	}
}
