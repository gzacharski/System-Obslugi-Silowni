package com.myprojects.gza.myGymApp.dao;

import java.util.List;

public interface DAO<T> {
	//Create
	boolean save(T t);
	
	//Read
	T getById(int id);
	List<T> getAll();
	List<T> search(String searchedPhrase);
	
	//update
	boolean update(T t);
	
	//Delete
	boolean delete(int id);
}
