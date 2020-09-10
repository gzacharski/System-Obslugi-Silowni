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
		Session currentSession=sessionFactory.getCurrentSession();
		
		return currentSession.get(Trainer.class, trainerId);
	}

	@Override
	public void deleteTrainer(int trainerId) {
		
		if(trainerId<=0) throw new IllegalArgumentException("Trainer id can't be lower or equal than 0");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.delete(getTrainer(trainerId));
	}

	@Override
	public List<Trainer> searchTrainer(String searchedPhrase) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Trainer> theQuery=null;

		if(searchedPhrase!=null && searchedPhrase.trim().length()>0) {
			theQuery=currentSession.createQuery("from Trainer where"
					+ " description like :theSearchedPhrase"
					+ " or user.name like :theSearchedPhrase"
					+ " or user.surname like :theSearchedPhrase"
					+ " or user.email like :theSearchedPhrase", Trainer.class);
			theQuery.setParameter("theSearchedPhrase", "%"+searchedPhrase+"%");
		}
		
		List<Trainer> searchedTrainers=theQuery.getResultList();
		
		System.out.println(searchedTrainers.toString());
		
		return searchedTrainers;
	}

	@Override
	public boolean saveTrainer(Trainer trainer) {
		
		if(trainer==null) return false;
		
		Session currentSession=sessionFactory.getCurrentSession();

		try {
			currentSession.saveOrUpdate(trainer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateTrainer(Trainer trainer) {
		return saveTrainer(trainer);
	}
}
