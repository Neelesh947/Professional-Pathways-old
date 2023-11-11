package com.jobportal.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.users.models.User;
import com.jobportal.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//create User
	@PostMapping
	public ResponseEntity<User> createUsers(@RequestBody User user)
	{
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> userlist=userService.getAllUsers();
		return ResponseEntity.ok(userlist);
	}
	
	
	//get Single users
	@GetMapping("/{userid}")
	public ResponseEntity<User> getUserByID(@PathVariable String userid)
	{
		User userlist=userService.getUserById(userid);
		return ResponseEntity.ok(userlist);
	}
}
