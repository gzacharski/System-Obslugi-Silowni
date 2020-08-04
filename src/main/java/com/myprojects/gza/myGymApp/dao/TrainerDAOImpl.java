package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Trainer;

@Repository
public class TrainerDAOImpl implements TrainerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Trainer> getTrainers() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Trainer> theQuery=currentSession.createQuery("from Trainer",Trainer.class);
		
		List<Trainer> trainers=theQuery.getResultList();
		
		return trainers;
	}

	@Override
	public Trainer getTrainer(int trainerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTrainer(int trainerId) {
		// TODO Auto-generated method stub

	}
}
