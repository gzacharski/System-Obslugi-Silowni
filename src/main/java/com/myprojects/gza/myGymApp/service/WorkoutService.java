package com.myprojects.gza.myGymApp.service;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.Workout;

public interface WorkoutService {
	List<Workout> getWorkouts();
	List<Workout> searchWorkouts(String theSearchWorkout);
	List<Workout> showClientWorkouts(int clientId);
	void deleteWorkout(int theId);
}
