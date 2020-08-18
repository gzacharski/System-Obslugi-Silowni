package com.myprojects.gza.myGymApp.service;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserTimestamp;

public interface UserAnalyticsService {
	boolean save(UserTimestamp userTimestamp);
	UserTimestamp getById(int userTimestampId);
	List<UserTimestamp> getAll();
	List<UserTimestamp> getUserTimestamps(User user);
	List<UserTimestamp> getUserTimestamps(int userId);
	
}
