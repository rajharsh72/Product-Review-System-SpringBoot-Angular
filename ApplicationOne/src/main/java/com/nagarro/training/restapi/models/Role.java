package com.nagarro.training.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author harshraj01
 *
 * Entity class to store the roles in the database
 */
@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;			//stores the id of a role
	
	@Column(nullable = false , unique = true)
	private String name;		//stores the name of a role

	//getter method to get the id of a role
	public Long getId() {
		return id;
	}

	//setter method to set the id of the role
	public void setId(Long id) {
		this.id = id;
	}

	//getter method to get the name of a role
	public String getName() {
		return name;
	}

	//setter method to set the name of the role
	public void setName(String name) {
		this.name = name;
	}

}
