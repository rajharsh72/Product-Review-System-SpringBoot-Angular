package com.nagarro.training.restapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.restapi.models.User;

public interface UserDao extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
