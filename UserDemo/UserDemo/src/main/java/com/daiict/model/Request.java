package com.daiict.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column
	private String cust_email;

	@Column
	private String request_cust_name;

	@Column
	private String request_cust_contact;

	@Column
	private String request_cust_address;

	@Column
	private int quantity;

	@Column
	private double total;

	@Column
	private String status;
	
	@Column
	private String email;

	@ManyToOne()
	@JoinColumn(name = "sid")
	private Service service;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
