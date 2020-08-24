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
	
	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Override
	public boolean delete(int id) {
		
		if(id<=0) return false;
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<User> theQuery=currentSession.createQuery("delete from User where id=:userId", User.class);
		theQuery.setParameter("userId", id);
		
		try {
			theQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
		
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
	public List<User> getAll() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<User> theQuery=currentSession.createQuery("from User",User.class);
		
		List<User> users=new ArrayList<User>();
		
		try {
			users=theQuery.getResultList();
		}catch(Exception e) {
			users=null;
			e.printStackTrace();
			logger.info(this.getClass().getName()+ " there is no users in the databse.");
		}
		
		return users;
	}

	@Override
	public User getById(int id) {
		
		if(id<=0) return null;
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		User theUser=null;
		
		try {
			theUser=currentSession.get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			theUser=null;
		}

		return theUser;
	}
	
	@Override
	public boolean save(User user) {
		
		if(user==null) return false;
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Override
	public List<User> search(String searchedPhrase) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<User> theQuery=null;
		
		if(searchedPhrase!=null && searchedPhrase.trim().length()>0) {
			theQuery=currentSession.createQuery("from User where lower(name) like :theSearchName "
					+ "or lower(surname) like :theSearchNam or lower(email) like :theSearchNam", User.class);
			theQuery.setParameter("theSearchName", "%"+searchedPhrase+"%");
		}else {
			
		}
		
		return null;
	}

	@Override
	public boolean update(User user) {
		
		return save(user);
	}
}
