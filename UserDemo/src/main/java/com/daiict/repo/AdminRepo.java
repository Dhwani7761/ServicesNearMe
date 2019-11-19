package com.daiict.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daiict.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {

	Admin findByEmail(String email);

	@Query(value = "SELECT pro.email from request req join professional pro on (req.sid=pro.sid) where req.id=?1 limit 1", nativeQuery = true)
	String updateService(long rId);
}
