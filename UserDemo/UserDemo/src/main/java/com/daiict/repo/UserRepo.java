package com.daiict.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepo extends JpaRepository<User, Integer> {

}
