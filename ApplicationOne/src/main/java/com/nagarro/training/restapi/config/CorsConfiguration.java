package com.nagarro.training.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nagarro.training.restapi.constants.Constants;

/**
 * Configuration for the CORS (Cross Origin Resource Sharing) rules
 * @author harshraj01
 *
 */
@Configuration
public class CorsConfiguration {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods(Constants.GET, Constants.PUT, Constants.POST, 
																	Constants.DELETE)
						.allowedHeaders("*")
						.allowedOriginPatterns("*")
						.allowCredentials(true);
				
			}
		};
	}
}
