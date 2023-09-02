package com.nagarro.training.restapi.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.training.restapi.dao.UserDao;
import com.nagarro.training.restapi.models.Role;
import com.nagarro.training.restapi.models.User;
import com.nagarro.training.restapi.services.UserService;
/**
 * Service class implementation for UserService interface to provide utilities to the
 * User Controller
 * @author harshraj01
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	/**
	 * Method to fetch all the users from the database
	 */
	@Override
	public List<User> getUsers(){
		return this.userDao.findAll();
	}
	
	/**
	 * Method to get a particular user based on the userId
	 */
	@Override
	public User getUser(Long userId) {
		if(this.userDao.existsById(userId)){
			return this.userDao.findById(userId).get();
		}
		return null;
	}
	
	/**
	 * Method to add a new user
	 */
	@Override
	public void addUser(User user) {
		Set<Role> roles= new HashSet<>();
		Role role = new Role();
		//setting the default role as USER
		role.setName("USER");
		role.setId(3L);
		roles.add(role);
		user.setRoles(roles);
		//Encoding the user password to BCrypt encoder
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		this.userDao.save(user);
		
	}
	
	/**
	 * Method to count the number of users in the database
	 */
	@Override
	public Long countUsers() {
		return this.userDao.count();
	}

}
