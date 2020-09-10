package com.myprojects.gza.myGymApp.dao;

import com.myprojects.gza.myGymApp.entity.Password;

public interface PasswordDAO {
	
	boolean save(Password password);
	Password get(int id);
}
