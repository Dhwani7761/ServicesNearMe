package com.daiict.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.model.CreateRequest;
import com.daiict.model.Request;
import com.daiict.model.RequestResponse;
import com.daiict.model.Service;
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
	public Request newRequest(@RequestBody CreateRequest req) {
		Request reqObj = new Request();
		reqObj.setCust_email(req.getCust_email());
		reqObj.setQuantity(req.getQuantity());
		reqObj.setRequest_cust_address(req.getRequest_cust_address());
		reqObj.setRequest_cust_contact(req.getRequest_cust_contact());
		reqObj.setRequest_cust_name(req.getRequest_cust_name());
		reqObj.setStatus("NOT DONE");
		reqObj.setService(serviceRepo.getOne(req.getSid()));
		reqObj.setEmail("");
		return reqRepo.save(reqObj);
	}

	@PostMapping("/generateBill")
	public double generateBill(@RequestParam(value = "rid") Long rid, Request req) {
		Request r = reqRepo.getOne(rid);
		Service s = r.getService();
		int quantity = r.getQuantity();
		double total;
		double cost = s.getCost();
		total = cost * quantity;
		r.setTotal(total);
		this.reqRepo.save(r);
		return total;
	}

	@PostMapping("/updateStatus")
	public String changeAddress(@RequestParam(value = "rid") Long rid, @RequestBody Request req) {
		Request r = reqRepo.getOne(rid);
		r.setStatus(req.getStatus());
		this.reqRepo.save(r);
		return "updated successfully";
	}
	@GetMapping("/getRequest")
	public ResponseEntity<List<RequestResponse>> getAll()
	{
		List<RequestResponse> result = new ArrayList<RequestResponse>();
		
		 List<Object[]> records = reqRepo.findRequests();
		 BigInteger requestId = null;
		 String requestCustomerEmail = "";
		 String requestCustomerName= "";
		 double total = 0;
		    for(int i=0;i<records.size();i++)
		    {
		    	Object[] requestDetails = records.get(i);
			    requestId = (BigInteger) requestDetails[0];
			    requestCustomerEmail = String.valueOf(requestDetails[1]);
			    requestCustomerName = String.valueOf(requestDetails[2]);
			    total = (double) requestDetails[3];
			    result.add(new RequestResponse(requestId, requestCustomerEmail, requestCustomerName, total));
		    }
		    return ResponseEntity.status(HttpStatus.OK)
		    		.body(result);
		           
	}
}
