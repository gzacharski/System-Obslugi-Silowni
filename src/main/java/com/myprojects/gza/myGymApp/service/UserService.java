package com.myprojects.gza.myGymApp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.helperClasses.NewUser;

public interface UserService extends UserDetailsService{
	User findByEmail(String email);
	User findByUserName(String userName);
	User getById(int id);
	void save(NewUser newUser);
	void save(User user);
	List<User> getAllUsers();
}
