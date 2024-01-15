package com.example.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.user.model.User;

public interface UserRepository extends JpaRepository <User,Integer> {

	
	@Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);


}
