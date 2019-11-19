package com.daiict.model;

import java.math.BigInteger;

public class RequestResponse {
	
	private BigInteger id;
	private String requestCustomerEmail = "";
	 private String requestCustomerName= "";
	 private double total;
	public RequestResponse(BigInteger id, String requestCustomerEmail, String requestCustomerName, double total) {
		super();
		this.id = id;
		this.requestCustomerEmail = requestCustomerEmail;
		this.requestCustomerName = requestCustomerName;
		this.total = total;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getRequestCustomerEmail() {
		return requestCustomerEmail;
	}
	public void setRequestCustomerEmail(String requestCustomerEmail) {
		this.requestCustomerEmail = requestCustomerEmail;
	}
	public String getRequestCustomerName() {
		return requestCustomerName;
	}
	public void setRequestCustomerName(String requestCustomerName) {
		this.requestCustomerName = requestCustomerName;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	 
	 
}
