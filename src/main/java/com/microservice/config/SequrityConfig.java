package com.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SequrityConfig  {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserInfoUserDetailsService() ;
	}
	@Bean
	public SecurityFilterChain securitychain(HttpSecurity http) throws Exception {
		return http.csrf().disable().
				authorizeHttpRequests().requestMatchers("/user/createUser").
				   permitAll().and().authorizeHttpRequests().
				   		requestMatchers("/user/{id}","/user/Updateuser/{id}").
				   		  authenticated().and().formLogin().and().build();
	}
	@Bean
	public PasswordEncoder pass() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(pass());
		return daoAuthenticationProvider;
		
	}

}
