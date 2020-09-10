package com.myprojects.gza.myGymApp.service;

import java.util.List;
import java.util.Map;

import com.myprojects.gza.myGymApp.entity.Place;

public interface PlaceService {
	List<Place> getPlaces();
	Place getById(int id);
	boolean addPlace(Place place);
	boolean editPlace(Place place);
	boolean deletePlace(int id);
	Map<Integer, String> getAllPlacesMappedById();
}
