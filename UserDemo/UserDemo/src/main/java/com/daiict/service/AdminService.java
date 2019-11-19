package com.daiict.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiict.model.Request;
import com.daiict.repo.AdminRepo;
import com.daiict.repo.RequestRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	RequestRepo requestRepo;

	public String updateService(long rId) {

		try {

			String email = adminRepo.updateService(rId);

			Request req = requestRepo.getOne(rId);

			req.setEmail(email);
			req.setStatus("assigned");
			requestRepo.save(req);
		} catch (Exception e) {

			return "not update";
		}

		return "update";

	}

}
