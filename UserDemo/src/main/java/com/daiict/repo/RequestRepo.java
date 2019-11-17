package com.daiict.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daiict.model.Request;

//@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface RequestRepo extends JpaRepository<Request, Long> {
}
