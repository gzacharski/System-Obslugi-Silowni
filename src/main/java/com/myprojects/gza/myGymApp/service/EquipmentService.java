package com.myprojects.gza.myGymApp.service;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.Equipment;
import com.myprojects.gza.myGymApp.errors.ThereIsNoSuchAnEquipmentException;

public interface EquipmentService {
	boolean save(Equipment equipment);
	Equipment getById(int id);
	List<Equipment> getAll();
	List<Equipment> search(String searchedPhrase);
	boolean update(Equipment equipment);
	boolean delete(int id) throws ThereIsNoSuchAnEquipmentException;
}
