package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Moddel.User;
import com.microservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		return user;
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		User us = userService.createUser(user);
		return us;
	}
	@PutMapping("/Updateuser/{id}")
	public User UpdateUser(@RequestBody User user,@PathVariable Long id) {
		User upd = userService.updateUser(id,user);
		return upd;
	}
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);	
	}

}
