package com.myprojects.gza.myGymApp.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.gza.myGymApp.dao.UserDAO;
import com.myprojects.gza.myGymApp.dao.WorkoutDAO;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService{
	
	@Autowired
	private WorkoutDAO workoutDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<Workout> getWorkouts() {
		return workoutDAO.getAll();
	}

	@Override
	@Transactional
	public List<Workout> searchWorkout(String theSearchWorkout) {
		return workoutDAO.search(theSearchWorkout);
	}

	@Override
	@Transactional
	public List<Workout> showClientWorkouts(int clientId) {
		
		User tempUser=userDAO.getById(clientId);
		
		
		return null;
	}

	@Override
	@Transactional
	public boolean deleteWorkout(int theId) {
		return workoutDAO.delete(theId);
	}

	@Override
	@Transactional
	public boolean addWorkout(Workout workout) {
		return workoutDAO.save(workout);
	}

	@Override
	@Transactional
	public boolean updateWorkout(Workout workout) {
		return workoutDAO.update(workout);
	}

	@Override
	@Transactional
	public Workout getWorkoutById(int theId) {
		return workoutDAO.getById(theId);
	}

	@Override
	@Transactional
	public Map<Integer, String> getAllTypesOfWorkoutMappedById() {
		
		return workoutDAO.getAll().stream()
			.collect(Collectors.toMap(Workout::getId, Workout::getTypeOfWorkout));
	}
}
