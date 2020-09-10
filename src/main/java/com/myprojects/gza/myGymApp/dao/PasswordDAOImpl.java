package com.myprojects.gza.myGymApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Password;

@Repository
public class PasswordDAOImpl implements PasswordDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean save(Password password) {
		
		if(password==null) return false;
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(password);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Password get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
