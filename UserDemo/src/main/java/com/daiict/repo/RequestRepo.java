package com.daiict.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daiict.model.Request;

public interface RequestRepo extends JpaRepository<Request, Long> {
	
	@Query(value = "select req.id, req.cust_email,req.request_cust_name,req.total from request req",nativeQuery = true)
	List<Object[]> findRequests();
}
