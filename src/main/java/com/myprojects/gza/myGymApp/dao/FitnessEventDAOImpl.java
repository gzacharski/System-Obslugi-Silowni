package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.FitnessEvent;

@Repository
public class FitnessEventDAOImpl implements FitnessEventDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(FitnessEvent fitnessEvent) {
		
		if(fitnessEvent==null) throw new NullPointerException("FitnessEvent can't be null");
			
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.save(fitnessEvent);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public FitnessEvent getById(int id) {
		
		if(id<=0) throw new IllegalArgumentException("ID can't be lower or equal than 0");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		FitnessEvent tempFitnessEvent=null;
		
		try {
			tempFitnessEvent=currentSession.get(FitnessEvent.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempFitnessEvent;
	}

	@Override
	public List<FitnessEvent> getAll() {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<FitnessEvent> theQuery=currentSession.createQuery("from FitnessEvent", FitnessEvent.class);
		
		List<FitnessEvent> fitnessEvents=theQuery.getResultList();
		
		return fitnessEvents;
	}

	@Override
	public List<FitnessEvent> search(String searchedPhrase) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<FitnessEvent> theQuery=null;
		
		if(searchedPhrase!=null && searchedPhrase.trim().length()>0) {
			theQuery=currentSession.createQuery("from FitnessEvent where "
					+ "description like :theSearchedPhrase", FitnessEvent.class);
			theQuery.setParameter("theSearchedPhrase", "%"+searchedPhrase+"%");
		}
		
		List<FitnessEvent> fitnessEvents=theQuery.getResultList();
		
		return fitnessEvents;
	}

	@Override
	public boolean update(FitnessEvent fitnessEvent) {
		if(fitnessEvent==null) return false;
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(fitnessEvent);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(int id) {
		
		if(id<=0) throw new IllegalArgumentException("ID can't be lower or equal than 0");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			FitnessEvent tempFitnessEvent=currentSession.load(FitnessEvent.class, id);
			
			currentSession.delete(tempFitnessEvent);
			currentSession.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
