package com.nagarro.training.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.restapi.models.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
