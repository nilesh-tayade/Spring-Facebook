package com.facebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.entities.LoginRequest;
import com.facebook.entities.User;
import com.facebook.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User login(LoginRequest loginRequest) {
		
		return userRepository.findByMobileAndPassword(loginRequest.getMobile(), loginRequest.getPassword());
	}

	@Override
	public void deleteUser(int id) {

		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getById(int id) {
		return userRepository.findById(id).get();
	}

}
