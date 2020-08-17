package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.User;

public interface UserDAO {
	User findByUserName(String userName);
	User findByEmail(String email);
	void save(User user);
	List<User> getAllUsers();
}
