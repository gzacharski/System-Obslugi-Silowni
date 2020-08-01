package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.Workout;

public interface WorkoutDAO {
	List<Workout> getWorkouts();
	List<Workout> searchWorkouts(String theSearchWorkout);
	List<Workout> showClientWorkouts(int clientId);
	void deleteWorkout(int theId);
	void addWorkout(Workout theWorkout);
}
