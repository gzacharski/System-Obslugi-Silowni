package com.myprojects.gza.myGymApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.UserAnalyticsDAO;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserTimestamp;

@Service
public class UserAnalyticsServiceImpl implements UserAnalyticsService {
	
	@Autowired
	private UserAnalyticsDAO userAnalyticsDAO;
	
	@Override
	@Transactional
	public boolean save(UserTimestamp userTimestamp) {
		return userAnalyticsDAO.save(userTimestamp);
	}

	@Override
	@Transactional
	public UserTimestamp getById(int userTimestampId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<UserTimestamp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<UserTimestamp> getUserTimestamps(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<UserTimestamp> getUserTimestamps(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
