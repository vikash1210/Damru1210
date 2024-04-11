package com.microservice.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.microservice.Moddel.User;
import com.microservice.repository.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<User> byUserName = Optional.ofNullable(userRepository.findByUserName(username));
		return byUserName.map(UserInfoUserDetail::new).
				orElseThrow(()-> new UsernameNotFoundException("User Not Found"+username));
	}

}
