package com.myprojects.gza.myGymApp.service;

import java.util.List;
import java.util.Map;

import com.myprojects.gza.myGymApp.entity.Workout;

public interface WorkoutService {
	List<Workout> getWorkouts();
	List<Workout> searchWorkout(String theSearchWorkout);
	List<Workout> showClientWorkouts(int clientId);
	Workout getWorkoutById(int theId);
	boolean deleteWorkout(int theId);
	boolean addWorkout(Workout workout);
	boolean updateWorkout(Workout workout);
	Map<Integer, String> getAllTypesOfWorkoutMappedById();
}
