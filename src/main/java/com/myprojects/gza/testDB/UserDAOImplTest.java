package com.myprojects.gza.testDB;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.myprojects.gza.myGymApp.dao.UserDAO;
import com.myprojects.gza.myGymApp.dao.UserDAOImpl;
import com.myprojects.gza.myGymApp.entity.User;

public class UserDAOImplTest {
	
	private static Logger logger=Logger.getLogger("myLogger");

	public static void main(String[] args) {
		
		List<User> users=new ArrayList<User>();
		
		UserDAO userDao=new UserDAOImpl();
		
		users=userDao.getAllUsers();
		
		for(User user: users) {
			logger.info(user.toString());
		}
		
	}

}
