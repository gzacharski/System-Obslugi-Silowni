package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Place;

@Repository
public class PlaceDAOImpl implements PlaceDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Place place) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(place);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Place getById(int id) {
		
		Session currentSession=sessionFactory.getCurrentSession();

		Place tempPlace=null;
		
		try {
			tempPlace=currentSession.get(Place.class, id);
		}catch(Exception e) {
			e.printStackTrace();
			tempPlace=null;
		}
			
		return tempPlace;
	}

	@Override
	public Place getByName(String name) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Place> theQuery=currentSession.createQuery("from Place where placeName=:name",Place.class);
		theQuery.setParameter("name", name);
		
		Place tempPlace=null;
		
		try {
			tempPlace=theQuery.getSingleResult();
		}catch(Exception e) {
			tempPlace=null;
		}
			
		return tempPlace;
	}
	
	@Override
	public List<Place> getAll() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Place> query=currentSession.createQuery("from Place order by placeName", Place.class);
		
		List<Place> places=query.getResultList();
		
		return places;
	}

	@Override
	public boolean delete(int id) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Place> query=currentSession.createQuery("delete from Place where id=:placeId", Place.class);
		query.setParameter("placeId", id);
		
		try {
			query.executeUpdate();
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Place place) {
		
		return save(place);
	}

	@Override
	public List<Place> search(String searchedPlace) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Place> theQuery=null;
		
		if(searchedPlace!=null && searchedPlace.trim().length()>0) {
			theQuery=currentSession.createQuery("from Place where lower(placeName) like :theSearchedName"
					+ " or lower(description) like :theSearchedName",Place.class);
			theQuery.setParameter("theSearchedName", "%"+searchedPlace+"%");
		}else {
			theQuery=currentSession.createQuery("from Place",Place.class);
		}
		
		List<Place> searchedPlaces=theQuery.getResultList();
		
		return searchedPlaces;
	}

	
	
}
