package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserTimestamp;

@Repository
public class UserAnalyticsDAOImpl implements UserAnalyticsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(UserTimestamp userTimestamp) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.save(userTimestamp);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public UserTimestamp getById(int id) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<UserTimestamp> theQuery=currentSession.createQuery("from UserTimestamp where id=:userTimestampId", UserTimestamp.class);
		theQuery.setParameter("userTimestampId", id);
		
		UserTimestamp tempUserTimestamp=null;
		
		try {
			tempUserTimestamp=theQuery.getSingleResult();
		} catch (Exception e) {
			tempUserTimestamp=null;
		}
		
		return tempUserTimestamp;
	}

	@Override
	public List<UserTimestamp> getAll() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<UserTimestamp> theQuery=currentSession.createQuery("from UserTimestamp order by userId", UserTimestamp.class);
		
		List<UserTimestamp> allUserTimestamps;
		
		try {
			allUserTimestamps = theQuery.getResultList();
		} catch (Exception e) {
			allUserTimestamps=null;
		}
		
		return allUserTimestamps;
	}

	@Override
	public List<UserTimestamp> search(String searchedPhrase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UserTimestamp userTimeStamp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserTimestamp> getUserTimestamps(User user) {
		return getUserTimestamps(user.getId());
	}

	@Override
	public List<UserTimestamp> getUserTimestamps(int userId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<UserTimestamp> theQuery=currentSession.createQuery("FROM UserTimestamp ORDER BY timestamp DSC WHERE userId=:tempUserId", UserTimestamp.class);
		theQuery.setParameter("tempUserId", userId);
		
		List<UserTimestamp> allTheUserTimestamps;
		
		try {
			allTheUserTimestamps=theQuery.getResultList();
		} catch (Exception e) {
			allTheUserTimestamps=null;
		}
		
		return allTheUserTimestamps;
	}

}
