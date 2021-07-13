package com.facebook.services;

import java.util.List;

import com.facebook.entities.LoginRequest;
import com.facebook.entities.User;

public interface UserService {
	
	public List<User> getAllUser();
	public User saveUser(User user);
	public User login(LoginRequest loginRequest);
	public void deleteUser(int id);
	public User updateUser(User user);
	public User getById(int id);

}
