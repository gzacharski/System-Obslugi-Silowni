package com.myprojects.gza.myGymApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.EquipmentDAO;
import com.myprojects.gza.myGymApp.entity.Equipment;
import com.myprojects.gza.myGymApp.errors.ThereIsNoSuchAnEquipmentException;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentDAO equipmentDAO;

	@Override
	@Transactional
	public boolean save(Equipment equipment) {
		
		return equipmentDAO.save(equipment);
	}

	@Override
	@Transactional
	public Equipment getById(int id) {
		
		return equipmentDAO.getById(id);
	}

	@Override
	@Transactional
	public List<Equipment> getAll() {

		return equipmentDAO.getAll();
	}

	@Override
	@Transactional
	public List<Equipment> search(String searchedPhrase) {
		
		return equipmentDAO.search(searchedPhrase);
	}

	@Override
	@Transactional
	public boolean update(Equipment equipment) {
		
		return equipmentDAO.update(equipment);
	}

	@Override
	@Transactional
	public boolean delete(int id) throws ThereIsNoSuchAnEquipmentException {
		
		if(equipmentDAO.getById(id)==null) {
			throw new ThereIsNoSuchAnEquipmentException();
		}
		
		return equipmentDAO.delete(id);
	}

}
