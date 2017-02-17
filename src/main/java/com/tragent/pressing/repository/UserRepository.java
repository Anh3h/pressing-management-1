package com.tragent.pressing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.tragent.pressing.model.CustomUser;

public interface UserRepository extends JpaRepository<CustomUser, Long>{
	
	CustomUser findByUsername(@Param("name") String name);

}
