package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Workout;

@Repository
public class WorkoutDAOImpl implements WorkoutDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Workout> getWorkouts() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Workout> theQuery=currentSession.createQuery("from Workout", Workout.class);
		
		List<Workout> workouts=theQuery.getResultList(); 
		
		return workouts;
	}

	@Override
	public List<Workout> searchWorkouts(String theSearchWorkout) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Workout> showClientWorkouts(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWorkout(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addWorkout(Workout theWorkout) {
		
		
	}
}
