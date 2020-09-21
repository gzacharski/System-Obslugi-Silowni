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
		
		//Query<User> theQuery=currentSession.createQuery("delete from User where id=:userId", User.class);
		//Query query1=currentSession.createQuery("delete from Password where id=:userId");
		Query query2=currentSession.createQuery("delete from User where id=:userId");
		//theQuery.setParameter("userId", id);
		//query1.setParameter("userId", id);
		query2.setParameter("userId", id);
		try {
			//theQuery.executeUpdate();
			//query1.executeUpdate();
			query2.executeUpdate();
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
		
		logger.info(user.toString());
		logger.info(user.getPassword().getPassword());

		try {
			currentSession.saveOrUpdate(user);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("bład");
			return false;
		}
		
		return true;
	}
	
	@Override
	public List<User> search(String searchedPhrase) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<User> theQuery=null;
		
		List<User> tempUsers=null;
		
		if(searchedPhrase!=null && searchedPhrase.trim().length()>0) {
			theQuery=currentSession.createQuery("from User where lower(name) like :theSearchName "
					+ "or lower(surname) like :theSearchName or lower(email) like :theSearchName", User.class);
			theQuery.setParameter("theSearchName", "%"+searchedPhrase+"%");
			tempUsers=theQuery.getResultList();
		}
		
		return tempUsers;
	}

	@Override
	public boolean update(User user) {
		
		if(user==null) return false;
		
		Session currentSession=sessionFactory.getCurrentSession();

		try {
			currentSession.saveOrUpdate(user);
		} catch (Exception e) {
			System.out.println("bład");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
