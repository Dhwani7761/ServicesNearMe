package com.daiict.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daiict.model.Professional;

public interface ProfessionalRepo extends JpaRepository<Professional, Long> {

	Professional findByEmail(String email);
}
