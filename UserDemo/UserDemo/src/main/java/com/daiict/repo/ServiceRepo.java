package com.daiict.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daiict.model.Service;

public interface ServiceRepo extends JpaRepository<Service, Long> {
	
}
