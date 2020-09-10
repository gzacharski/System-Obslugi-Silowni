package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.gza.myGymApp.entity.Equipment;

@Repository
public class EquipmentDAOImpl implements EquipmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Equipment equipment) {
		
		if(equipment==null) throw new NullPointerException("Equipment can't be null");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(equipment);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Equipment getById(int id) {

		if(id<=0) throw new IllegalArgumentException("Equipment id can not be equal or lower than zero");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Equipment tempEquipment;
		
		try {
			tempEquipment = currentSession.get(Equipment.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			tempEquipment=null;
		}
		
		return tempEquipment;
	}

	@Override
	public List<Equipment> getAll() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Equipment> query=currentSession.createQuery("from Equipment", Equipment.class);
		
		List<Equipment> equipmentList=null;
		try {
			equipmentList=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			equipmentList=null;
		}
			
		return equipmentList;
	}

	@Override
	public List<Equipment> search(String searchedPhrase) {
			
		Session currenSession=sessionFactory.getCurrentSession();
		
		Query<Equipment> query=null;
		
		if(searchedPhrase!=null && searchedPhrase.trim().length()>0) {
			query=currenSession.createQuery("from Equipment where lower(name) like :thePhrase"
					+ "od lower(description) like :thePhrase" , Equipment.class);
			query.setParameter("thePhrase", "%"+searchedPhrase+"%");
		}

		List<Equipment> searchedEquipment=query.getResultList();
		
		return searchedEquipment;
	}

	@Override
	public boolean update(Equipment equipment) {
		
		return save(equipment);
	}

	@Override
	public boolean delete(int id) {
		
		if(id<=0) throw new IllegalArgumentException("Equipment id can not be equal or lower than zero");
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		try {
			Equipment tempEquipment=currentSession.load(Equipment.class, id);

			currentSession.delete(tempEquipment);
			currentSession.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
