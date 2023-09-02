package com.nagarro.training.restapi.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author harshraj01
 * Entity class that stores the user data in the database
 */
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;			//stores the id of a user
	
	@Column(nullable = false, unique = true)
	private String email;		//stores the email of a user
	
	private String first_name;	//stores the first name of the user
	private String last_name;	//stores the last name of the user
	
	@Column(nullable = false)
	private String password;	//stores the password of the user
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"),
									inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;	//stores the role of a particular user

	//getter method to get the id of the user
	public long getId() {
		return id;
	}

	//setter method to set the values to the class variable
	public void setId(long id) {
		this.id = id;
	}

	//getter method to get the email of the user
	public String getEmail() {
		return email;
	}

	//setter method to set the values to the class variable
	public void setEmail(String email) {
		this.email = email;
	}

	//getter method to get the first name of the user
	public String getFirst_name() {
		return first_name;
	}

	//setter method to set the values to the class variable
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	//getter method to get the last name of the user
	public String getLast_name() {
		return last_name;
	}

	//setter method to set the values to the class variable
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	//getter method to get the password of the user
	public String getPassword() {
		return password;
	}

	//setter method to set the values to the class variable
	public void setPassword(String password) {
		this.password = password;
	}

	//getter method to get the  roles of the user
	public Set<Role> getRoles() {
		return roles;
	}

	//setter method to set the values to the class variable
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", roles=" + roles + "]";
	}
}
