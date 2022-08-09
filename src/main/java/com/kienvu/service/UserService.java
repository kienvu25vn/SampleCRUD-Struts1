package com.kienvu.service;

import java.util.List;

import com.kienvu.model.User;
import com.kienvu.repository.UserRepository;
import com.sun.java_cup.internal.internal_error;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepository();
	}
	
	public int saveUser(User user) {
		try {
			return userRepository.insertUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	public List<User> getAllUsers(){
		return userRepository.getUsers();
	}
	
	public int deleteUser(int idUser) {
		return userRepository.removeUser(idUser);
	}
}
