package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.Moddel.User;
import com.microservice.exception.UserNotFound;
import com.microservice.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		System.out.println(user.getPassword() + "Getting password-------------");

		String encode = passwordEncoder.encode(user.getPassword());
		user.setPassword(encode);
		
		  String mobileNoAsString = String.valueOf(user.getMobileNo()); long lo =
		  Long.parseLong(passwordEncoder.encode(mobileNoAsString));
		  user.setMobileNo(lo);
		  //user.setMobileNo(passwordEncoder.encode(user.getMobileNo()));
		 
		User usr = userRepository.save(user);

		return usr;
	}

	@Override
	public User updateUser(Long id, User user) throws UserNotFound {
		User usr = userRepository.findById(id).orElseThrow(() -> new UserNotFound("Invalid User"));
		usr.setUserName(user.getUserName());
		usr.setMobileNo(user.getMobileNo());
		usr.setPassword(user.getPassword());
		usr.setEmail(user.getEmail());
		userRepository.save(usr);
		return usr;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getUser(Long id) {
		User byId = userRepository.findById(id).orElseThrow(() -> new UserNotFound("user Not Found"));
		return byId;
	}

}
