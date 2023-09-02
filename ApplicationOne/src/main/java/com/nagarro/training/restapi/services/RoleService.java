package com.nagarro.training.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.training.restapi.models.Role;

public interface RoleService {

	List<Role> getRoles();

	Role getRole(Long roleId);

	void updateRole(Role role);

	void deleteRole(Long roleId);

	void addRole(Role role);

}
