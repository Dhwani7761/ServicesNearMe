package com.daiict.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daiict.model.Customer;

//@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepo extends JpaRepository<Customer, String> {
	
	Customer findByEmail(String email);

}
