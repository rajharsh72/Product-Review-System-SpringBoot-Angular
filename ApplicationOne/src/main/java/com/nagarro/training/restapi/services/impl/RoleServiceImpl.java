package com.nagarro.training.restapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.restapi.dao.RoleDao;
import com.nagarro.training.restapi.models.Role;
import com.nagarro.training.restapi.services.RoleService;

/**
 * Service class implementation for RoleService interface to provide utilities to the
 * Role Controller
 * @author harshraj01
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	public RoleDao roleDao;
	
	@Override
	public void addRole(Role role) {
		roleDao.save(role);
	}
	
	/**
	 * Method to fetch all the roles from the database
	 */
	@Override
	public List<Role> getRoles(){
		return roleDao.findAll();
	}
	
	/**
	 * Method to fetch role base on the roleId
	 */
	@Override
	public Role getRole(Long roleId) {
		if(roleDao.existsById(roleId)) {
			return roleDao.getReferenceById(roleId);
		}
		return null;
	}
	
	/**
	 * Method to update any role
	 */
	@Override
	public void updateRole(Role role) {
		roleDao.save(role);
	}
	
	/**
	 * Method to delete any role based on the roleId
	 */
	@Override
	public void deleteRole(Long roleId) {
		Role role = roleDao.getReferenceById(roleId);
		roleDao.delete(role);
	}

}
