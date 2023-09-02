package com.nagarro.training.restapi.services;

import java.util.List;

import com.nagarro.training.restapi.models.User;

/**
 * Interface that contains the methods to be used by the User Controller  
 * @author harshraj01
 *
 */
public interface UserService {

	List<User> getUsers();		//get all users
	User getUser(Long userId);	//get user based on the id
	void addUser(User user);	//add user in the database
	Long countUsers();			//count the users in the database

}
