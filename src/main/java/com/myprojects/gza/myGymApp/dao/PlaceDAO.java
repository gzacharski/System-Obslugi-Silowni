package com.myprojects.gza.myGymApp.dao;

import com.myprojects.gza.myGymApp.entity.Place;

public interface PlaceDAO extends DAO<Place>{
	//Read
	Place getByName(String name);
}
