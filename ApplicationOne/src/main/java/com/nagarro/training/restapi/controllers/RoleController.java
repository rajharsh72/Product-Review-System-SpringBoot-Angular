package com.nagarro.training.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.restapi.models.Role;
import com.nagarro.training.restapi.services.RoleService;

/**
 * REST Controller that contains handler methods for the role endpoints
 * @author harshraj01
 *
 */
@RestController
@RequestMapping("/api")
public class RoleController {
	
	//autowiring the role service interface
	@Autowired
	public RoleService roleService;
	
	/**
	 * Handler method to fetch all the roles from the database
	 * @return
	 */
	@GetMapping("/role")
	public List<Role> getAllRoles()
	{
		return this.roleService.getRoles();
	}
	
	/**
	 * Handler method to fetch the role with a particular roleId
	 * @param roleId
	 * @return Role
	 */
	@GetMapping("/role/{roleId}")
	public Role getRole(@PathVariable String roleId) {
		return this.roleService.getRole(Long.parseLong(roleId));
	}
	
	/**
	 * Handler method to add a new role in the database
	 * @param role new value of the role to be added
	 * @return ResponseEntity
	 */
	@PostMapping("/role")
	public ResponseEntity<HttpStatus> addRole(@RequestBody Role role){
		try {
			this.roleService.addRole(role);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Handler method to update a role 
	 * @param role
	 * @return ResponseEntity
	 */
	@PutMapping("/role")
	public ResponseEntity<HttpStatus> updateRole(@RequestBody Role role){
		try {
			this.roleService.updateRole(role);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Handler method to delete a particular role based on the roleId
	 * @param roleId
	 * @return ResponseEntity
	 */
	@DeleteMapping("role/{roleId}")
	public ResponseEntity<HttpStatus> deleteRole(@PathVariable String roleId){
		try {
			this.roleService.deleteRole(Long.parseLong(roleId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
