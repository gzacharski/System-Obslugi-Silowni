package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Workout;

@Repository
public class WorkoutDAOImpl implements WorkoutDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Workout workout) {
		
		if(workout==null) throw new IllegalArgumentException("Workout can't be null");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(workout);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Workout getById(int id) {
		
		if(id<=0) throw new IllegalArgumentException("ID can't be lower or queal than 0.");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Workout tempWorkout=currentSession.get(Workout.class, id);
		
		return tempWorkout;
	}

	@Override
	public List<Workout> getAll() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Workout> theQuery=currentSession.createQuery("from Workout", Workout.class);
		
		List<Workout> workouts=theQuery.getResultList(); 
		
		return workouts;
	}

	@Override
	public List<Workout> search(String searchedPhrase) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Workout> theQuery=null;
		
		if(searchedPhrase!=null && searchedPhrase.trim().length()>0) {
			theQuery=currentSession.createQuery("from Workout where "
					+ "description like :theSearchedPhrase or "
					+ "typeOfWorkout like :theSearchedPhrase", Workout.class);
			theQuery.setParameter("theSearchedPhrase", "%"+searchedPhrase+"%");
		}
		
		List<Workout> workouts=theQuery.getResultList();
		
		return workouts;
	}

	@Override
	public boolean update(Workout workout) {
		
		if(workout==null) return false;
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(workout);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(int id) {
		
		if(id<=0) throw new IllegalArgumentException("ID can't be lower or queal than 0.");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			Workout tempWorkout=currentSession.load(Workout.class, id);
			currentSession.delete(tempWorkout);
			currentSession.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return  true;
	}
}
