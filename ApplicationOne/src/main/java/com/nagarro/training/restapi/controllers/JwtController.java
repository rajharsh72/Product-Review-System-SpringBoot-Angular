package com.nagarro.training.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.restapi.models.JwtRequest;
import com.nagarro.training.restapi.models.JwtResponse;
import com.nagarro.training.restapi.services.impl.AuthServiceImpl;

/**
 * 
 * @author harshraj01
 * REST Controller that conatains the handlers for the user authentication and generation of 
 * JWT Token
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class JwtController {

	//autowiring the authorization service class
	@Autowired
	private AuthServiceImpl authService;
	
	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		//returns the jwt token for the authenticated user
		return this.authService.createJwtToken(jwtRequest);
	}

}
