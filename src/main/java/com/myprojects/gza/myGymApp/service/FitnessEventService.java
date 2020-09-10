package com.myprojects.gza.myGymApp.service;

import java.time.LocalDate;
import java.util.List;

import com.myprojects.gza.myGymApp.entity.FitnessEvent;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.errors.RemovalOfUserFromFitnessEventException;
import com.myprojects.gza.myGymApp.errors.SigningUpToFitnessEventException;

public interface FitnessEventService {
	List<FitnessEvent> getAll();
	List<FitnessEvent> getAllEventsInSpecifiedWeek(LocalDate localDate);
	FitnessEvent getById(int id);
	boolean delete(int id);
	boolean update(FitnessEvent fitnessEvent);
	boolean save(FitnessEvent fitnessEvent);
	List<FitnessEvent> getUserEventsInCurrentWeek(User theUser, LocalDate localDate);
	boolean addNewParticipantToFitnessEvent(User theUser, int fitnessEventId) throws SigningUpToFitnessEventException;
	boolean removeParticipantFromFitnessEvent(User theUser, int fitnessEventId) throws RemovalOfUserFromFitnessEventException;

}
