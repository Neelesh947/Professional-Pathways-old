package com.jobportal.users.service;

import java.util.List;

import com.jobportal.users.models.User;

public interface UserService {

	//create user and save it
	
	User saveUser(User user);

	// find all the user
	List<User> getAllUsers();

	
	// find the user by id
	User getUserById(String userid);
}
