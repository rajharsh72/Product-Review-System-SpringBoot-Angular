package com.nagarro.training.restapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.nagarro.training.restapi.config.JwtUtil;
import com.nagarro.training.restapi.dao.UserDao;
import com.nagarro.training.restapi.models.JwtRequest;
import com.nagarro.training.restapi.models.JwtResponse;
import com.nagarro.training.restapi.models.User;
import com.nagarro.training.restapi.services.AuthService;

/**
 * Service class implementation of AuthService used for generating of jwt tokens
 * and to authenticate the user as well 
 * @author harshraj01
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetails;
	
	/**
	 * Method that generates a jwt token used for authorization headers
	 * @param jwtRequest
	 * @return JwtToken assigned to the user
	 * @throws Exception
	 */
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
		String username = jwtRequest.getUsername();
		String userPassword = jwtRequest.getUserPassword();
		this.authenticate(username, userPassword);
		final UserDetails userDetails = this.userDetails.loadUserByUsername(username);
		
		//generating a new token
		String newGeneratedToken = this.jwtUtil.generateToken(userDetails);
		//finding a user based on the email
		User user = this.userDao.findByEmail(username);
		
		//returns a new jwt token for the user
		return new JwtResponse(user, newGeneratedToken);
	}
	
	/**
	 * Method to authenticate the user
	 * @param username
	 * @param userPassword
	 * @throws Exception
	 */
	private void authenticate(String username, String userPassword) throws Exception {
		try {
			
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, userPassword));
		}catch(DisabledException e) {
			throw new Exception("User is disabled");
		}catch(BadCredentialsException e) {
			throw new Exception("Bad credentials from user");
			
		}
	}

}
