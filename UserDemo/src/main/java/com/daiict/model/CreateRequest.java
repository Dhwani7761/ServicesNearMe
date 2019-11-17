package com.daiict.model;

import java.io.Serializable;

public class CreateRequest implements Serializable{

	
	private String cust_email;
	private String request_cust_name;
	private String request_cust_contact;
	private String request_cust_address;	
	private int quantity;
	private double total;
	private String status;
	private long sid;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getRequest_cust_name() {
		return request_cust_name;
	}

	public void setRequest_cust_name(String request_cust_name) {
		this.request_cust_name = request_cust_name;
	}

	public String getRequest_cust_contact() {
		return request_cust_contact;
	}

	public void setRequest_cust_contact(String request_cust_contact) {
		this.request_cust_contact = request_cust_contact;
	}

	public String getRequest_cust_address() {
		return request_cust_address;
	}

	public void setRequest_cust_address(String request_cust_address) {
		this.request_cust_address = request_cust_address;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	

}
