package com.microservice.service;

import com.microservice.Moddel.User;

public interface UserService  {
	
	 User createUser(User user);
	 User updateUser(Long id,User user);
	 void deleteUser(Long id);
	 User getUser(Long id);

}
