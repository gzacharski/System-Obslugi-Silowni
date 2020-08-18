package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.UserTimestamp;

public interface UserAnalyticsDAO extends DAO<UserTimestamp>{
	List<UserTimestamp> getUserTimestamps(User user);
	List<UserTimestamp> getUserTimestamps(int userId);
}
