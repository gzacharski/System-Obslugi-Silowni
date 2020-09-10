package com.myprojects.gza.myGymApp.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.PlaceDAO;
import com.myprojects.gza.myGymApp.entity.Place;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceDAO placeDAO;

	@Override
	@Transactional
	public List<Place> getPlaces() {
		return placeDAO.getAll();
	}

	@Override
	@Transactional
	public Place getById(int id) {
		return placeDAO.getById(id);
	}

	@Override
	@Transactional
	public boolean addPlace(Place place) {
		return placeDAO.save(place);
	}

	@Override
	@Transactional
	public boolean editPlace(Place place) {
		return placeDAO.update(place);
	}

	@Override
	@Transactional
	public boolean deletePlace(int id) {
		return placeDAO.delete(id);
	}

	@Override
	@Transactional
	public Map<Integer, String> getAllPlacesMappedById() {
		return placeDAO.getAll().stream()
				.collect(Collectors.toMap(Place::getId, Place::getPlaceName));
	}

}
