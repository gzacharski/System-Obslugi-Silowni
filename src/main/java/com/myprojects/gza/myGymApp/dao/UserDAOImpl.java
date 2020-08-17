package com.myprojects.gza.myGymApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger=Logger.getLogger("AppAuthenticationSuccessHandlerLogger");
		
	@Override
	public User findByUserName(String userName) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<User> theQuery=currentSession.createQuery("from User where userName=:uName", User.class);
		
		theQuery.setParameter("uName", userName);
		
		User theUser=null;
		
		try {
			theUser=theQuery.getSingleResult();
		}catch(Exception e) {
			theUser=null;
		}
		
		return theUser;
	}

	@Override
	public void save(User user) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(user);
	}

	@Override
	public User findByEmail(String email) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<User> theQuery=currentSession.createQuery("from User where email=:userEmail", User.class);
		
		theQuery.setParameter("userEmail", email);
		
		User theUser=null;
		
		try {
			theUser=theQuery.getSingleResult();
		}catch(Exception e) {
			logger.info("error?");
			theUser=null;
		}
		
		if(theUser!=null) logger.info("\nUserDAOImpl: "+theUser.toString());
		
		return theUser;
	}

	@Override
	public List<User> getAllUsers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<User> theQuery=currentSession.createQuery("from User",User.class);
		
		List<User> users=new ArrayList<User>();
		
		try {
			users=theQuery.getResultList();
		}catch(Exception e) {
			throw new RuntimeException(this.getClass().getName()+ " there is no users in the databse.");
		}
		
		return users;
	}
}
