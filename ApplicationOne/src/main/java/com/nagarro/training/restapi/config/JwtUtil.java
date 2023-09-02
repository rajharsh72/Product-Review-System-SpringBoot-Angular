package com.nagarro.training.restapi.config;

import java.security.KeyPair;
import com.nagarro.training.restapi.constants.Constants;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * Component that provides various utilities for the web security configurations
 * @author harshraj01
 *
 */
@Component
public class JwtUtil {
	
	//getting keys for authentication based on RS512 algorithm
	private final KeyPair keys = Keys.keyPairFor(SignatureAlgorithm.RS512);
	
//	private SecretKey getSecretKey() {
//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//		return key;
//	}
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
		
	}
	
	//higher order function that get or return a function as a parameter
	private <T> T getClaimFromToken(String token, Function<Claims,T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		
		return claimResolver.apply(claims);
		
	}
	
	private Claims getAllClaimsFromToken(String token) {
		//String base64Key = Encoders.BASE64.encode(getSecretKey().getEncoded());
		return Jwts.parserBuilder().setSigningKey(keys.getPublic())
				.build().parseClaimsJws(token).getBody();
	}
	
	//Method to validate the token assigned to the user
	public boolean validateToken(String token, UserDetails userDetails) {
		String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	//method to check if the token is expired or not
	private boolean isTokenExpired(String token) {
		final Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(new Date());
	}
	
	//method that returns the expiration data of a token
	private Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	//method to generate token using the private keys
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_VALIDITY*1000))
				.signWith(keys.getPrivate()).compact();
	}

}
