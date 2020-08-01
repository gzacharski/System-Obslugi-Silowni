package com.myprojects.gza.myGymApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.gza.myGymApp.dao.WorkoutDAO;
import com.myprojects.gza.myGymApp.entity.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService{
	
	@Autowired
	private WorkoutDAO workoutDAO;
	
	@Override
	@Transactional
	public List<Workout> getWorkouts() {
		return workoutDAO.getWorkouts();
	}

	@Override
	@Transactional
	public List<Workout> searchWorkouts(String theSearchWorkout) {
		return null;
	}

	@Override
	@Transactional
	public List<Workout> showClientWorkouts(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteWorkout(int theId) {
		
	}
}
