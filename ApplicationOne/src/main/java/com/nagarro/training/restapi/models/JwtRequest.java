package com.nagarro.training.restapi.models;

/**
 * 
 * @author harshraj01
 * JWT request class that will authenticate the username and userpassword from the endpoints 
 *
 */
public class JwtRequest {
	
	private String username;		//store the username 
	private String userPassword;	//store the userPassword
	
	//getter method to get the username
	public String getUsername() {
		return username;
	}
	
	//setter method to set the username to the class variables
	public void setUsername(String username) {
		this.username = username;
	}
	
	//getter method to get the user password
	public String getUserPassword() {
		return userPassword;
	}
	
	//setter method to set the userPassword to the class variables
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	

}
