package com.daiict.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;

	@Column
	private String name;
	
	@Column
	private double cost;

	//@OneToMany(targetEntity=Request.class, mappedBy="service",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    //@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Request> req;

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Request> getReq() {
		return req;
	}

	public void setReq(List<Request> req) {
		this.req = req;
	}
	
	
}
