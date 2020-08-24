package com.myprojects.gza.myGymApp.dao;

import com.myprojects.gza.myGymApp.entity.User;

public interface UserDAO extends DAO<User>{
	User findByUserName(String userName);
	User findByEmail(String email);
}
