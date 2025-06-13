package com.cdac.FourthSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cdac.FourthSpring.components.User;

@Configuration
public class ApplicationConfig {
	
	@Bean
	@Scope("prototype")
	public User objUser() {
		return new User();
	}
}
