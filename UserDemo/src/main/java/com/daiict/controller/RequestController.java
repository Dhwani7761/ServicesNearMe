package com.daiict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.model.CreateRequest;
import com.daiict.model.Customer;
import com.daiict.model.Request;
import com.daiict.model.Service;
import com.daiict.repo.CustomerRepo;
import com.daiict.repo.RequestRepo;
import com.daiict.repo.ServiceRepo;


@RestController
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RequestRepo reqRepo;
	
	@Autowired
	private ServiceRepo serviceRepo;
	
	@PostMapping("/save")
	public Request newRequest(@RequestBody CreateRequest req)
	{
		Request reqObj = new Request();
		reqObj.setCust_email(req.getCust_email());
		reqObj.setQuantity(req.getQuantity());
		reqObj.setRequest_cust_address(req.getRequest_cust_address());
		reqObj.setRequest_cust_contact(req.getRequest_cust_contact());
		reqObj.setRequest_cust_name(req.getRequest_cust_name());
		reqObj.setStatus("NOT DONE");
		reqObj.setService(serviceRepo.getOne(req.getSid()));
		return reqRepo.save(reqObj);
	}
	
	@PostMapping("/generateBill")
	public double generateBill(@RequestParam(value = "rid") Long rid,Request req)
	{
		Request r = reqRepo.getOne(rid);
		Service s =  r.getService();
		int quantity = r.getQuantity();
		double total;
		double cost = s.getCost();
		total = cost * quantity;
		r.setTotal(total);
		this.reqRepo.save(r);
		return total; 
	}
	@PostMapping("/updateStatus")
	public String changeAddress(@RequestParam(value = "rid") Long rid,@RequestBody Request req)
	{
		Request r = reqRepo.getOne(rid);
		r.setStatus(req.getStatus());
		this.reqRepo.save(r);
		return "updated successfully";
	}
}
