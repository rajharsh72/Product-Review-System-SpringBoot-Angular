package com.nagarro.training.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.restapi.models.User;
import com.nagarro.training.restapi.services.UserService;

/**
 * REST Controller that contains the handler methods for the user endpoint
 * @author harshraj01
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {
	
	//autowiring the user service interface
	@Autowired
	private UserService userService;
	
	/**
	 * Handler method to fetch all the users from the database
	 * @return List of Users
	 */
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return this.userService.getUsers();
	}
	
	/**
	 * Handler method to fetch a user based on the userId
	 * @param userId
	 * @return User
	 */
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable String userId) {
		return this.userService.getUser(Long.parseLong(userId));
	}
	
	/**
	 * Handler method to register a new user in the database
	 * @param user
	 */
	@PostMapping("/user")
	public void register(@RequestBody User user) {
		this.userService.addUser(user);
	}
	
	/**
	 * Handler method to count the users in the database
	 * @return Long value of the users in the database
	 */
	@GetMapping("/user/count")
	public Long countUser() {
		return this.userService.countUsers();
	}
}
