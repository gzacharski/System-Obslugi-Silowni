package com.myprojects.gza.myGymApp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.FitnessEventDAO;
import com.myprojects.gza.myGymApp.dao.PlaceDAO;
import com.myprojects.gza.myGymApp.dao.TrainerDAO;
import com.myprojects.gza.myGymApp.dao.WorkoutDAO;
import com.myprojects.gza.myGymApp.entity.FitnessEvent;
import com.myprojects.gza.myGymApp.entity.Place;
import com.myprojects.gza.myGymApp.entity.Trainer;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.Workout;
import com.myprojects.gza.myGymApp.errors.ChronologicalSigingUpToFitnessEventException;
import com.myprojects.gza.myGymApp.errors.MaxNumberOfPeopleInTheFitnessEventException;
import com.myprojects.gza.myGymApp.errors.NoSuchAUserOnFitnessEventListException;
import com.myprojects.gza.myGymApp.errors.RemovalOfUserFromFitnessEventException;
import com.myprojects.gza.myGymApp.errors.SigningUpToFitnessEventException;
import com.myprojects.gza.myGymApp.errors.TooEarlyException;
import com.myprojects.gza.myGymApp.errors.TooLateException;
import com.myprojects.gza.myGymApp.errors.UserAlreadyParticipatesInTheFitnessEventException;
import com.myprojects.gza.myGymApp.errors.UserCanNotCancelParticipationFromPastFitnessEventsException;
import com.myprojects.gza.myGymApp.errors.UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts;

@Service
public class FitnessEventServiceImpl implements FitnessEventService{
	
	@Autowired
	private FitnessEventDAO fitnessEventDAO;
	
	@Autowired
	private TrainerDAO trainerDAO;
	
	@Autowired
	private PlaceDAO placeDAO;
	
	@Autowired
	private WorkoutDAO workoutDAO;

	@Override
	@Transactional
	public List<FitnessEvent> getAll() {
		
		List<FitnessEvent> fitnessEvents=fitnessEventDAO.getAll();
		
		for(FitnessEvent event: fitnessEvents) {
			Hibernate.initialize(event.getTrainer().getUser());
		}
		
		return fitnessEvents;
	}

	@Override
	@Transactional
	public FitnessEvent getById(int id) {
		
		FitnessEvent tempEvent=fitnessEventDAO.getById(id);
		Hibernate.initialize(tempEvent.getTrainer().getUser());
		
		return tempEvent;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		return fitnessEventDAO.delete(id);
	}

	@Override
	@Transactional
	public boolean update(FitnessEvent fitnessEvent) {
		return fitnessEventDAO.update(fitnessEvent);
	}

	@Override
	@Transactional
	public boolean save(FitnessEvent fitnessEvent) {
		
		Place tempPlace=placeDAO.getById(fitnessEvent.getPlace().getId());
		Workout tempWorkout=workoutDAO.getById(fitnessEvent.getWorkout().getId());
		Trainer tempTrainer=trainerDAO.getTrainer(fitnessEvent.getTrainer().getId());
		
		fitnessEvent.setTrainer(tempTrainer);
		fitnessEvent.setPlace(tempPlace);
		fitnessEvent.setWorkout(tempWorkout);

		return fitnessEventDAO.save(fitnessEvent);
	}

	@Override
	@Transactional
	public List<FitnessEvent> getAllEventsInSpecifiedWeek(LocalDate localDate) {
		
		List<FitnessEvent> theFitnessEvents=fitnessEventDAO.getAll().stream()
				.filter(filterToGetEventsInSelectedWeek(localDate)).collect(Collectors.toList());
		
		for(FitnessEvent event: theFitnessEvents) {
			Hibernate.initialize(event.getTrainer().getUser());
		}
		
		return theFitnessEvents;
	}
	
	private LocalDate getDateOfMondayOfTheWeek(LocalDate localDate) {
		return localDate.minusDays(localDate.getDayOfWeek().getValue()-1);
	}
	
	private LocalDate getDateOfSundayOfTheWeek(LocalDate localDate) {
		return localDate.plusDays(7-localDate.getDayOfWeek().getValue());
	}
	
	private Predicate<FitnessEvent> filterToGetEventsInSelectedWeek(LocalDate anyDateOfSelectedWeek){
		
		LocalDate mondayOfCurrentWeek=getDateOfMondayOfTheWeek(anyDateOfSelectedWeek);
	
		LocalDate sundayOfCurrentWeek=getDateOfSundayOfTheWeek(anyDateOfSelectedWeek);
		
		return event -> event.getStartTime().toLocalDate().isAfter(mondayOfCurrentWeek) 
				&& event.getStartTime().toLocalDate().isBefore(sundayOfCurrentWeek);
	}

	@Override
	@Transactional
	public List<FitnessEvent> getUserEventsInCurrentWeek(User theUser, LocalDate localDate) {

		List<FitnessEvent> fitnessEventsInCurrentWeek=fitnessEventDAO.getAll()
				.stream()
				.filter(filterToGetEventsInSelectedWeek(localDate))
				.collect(Collectors.toList());
		
		List<FitnessEvent> userFitnessEvents=fitnessEventsInCurrentWeek
				.stream()
				.filter(event -> event.getUsers().contains(theUser))
				.collect(Collectors.toList());
	
		for(FitnessEvent event: userFitnessEvents) {
			Hibernate.initialize(event.getTrainer().getUser());
		}
	
		return userFitnessEvents;
	}

	@Override
	@Transactional
	public boolean addNewParticipantToFitnessEvent(User theUser, int fitnessEventId) throws SigningUpToFitnessEventException {
		
		if(theUser==null || fitnessEventId <=0) {
			throw new IllegalArgumentException();
		}
		
		FitnessEvent tempFitnessEvent=fitnessEventDAO.getById(fitnessEventId);
		
		if(tempFitnessEvent.getUsers().contains(theUser)) {
			throw new UserAlreadyParticipatesInTheFitnessEventException("User is not allowed "
					+ "to sign up twice on the same fitness event.");
		}
		
		if(tempFitnessEvent.getUsers().size()>=tempFitnessEvent.getMaxPeople()) {
			throw new MaxNumberOfPeopleInTheFitnessEventException("There is no place to add new participant in the fitness event."
					+ " User should cancel or join reserve list.");
		}
		
		if(tempFitnessEvent.getStartTime().isBefore(LocalDateTime.now())) {
			throw new ChronologicalSigingUpToFitnessEventException("User can't sign up to past event", new TooLateException());
		}
		
		if(tempFitnessEvent.getStartTime().minusDays(7).isAfter(LocalDateTime.now())) {
			throw new ChronologicalSigingUpToFitnessEventException("User is not allowed to sign up to the fitness event more "
					+ "than 7 days in advance.", new TooEarlyException());
		}

		tempFitnessEvent.getUsers().add(theUser);
		
		try {
			fitnessEventDAO.update(tempFitnessEvent);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public boolean removeParticipantFromFitnessEvent(User theUser, int fitnessEventId) throws RemovalOfUserFromFitnessEventException {
		
		if(theUser==null || fitnessEventId <=0) {
			throw new IllegalArgumentException();
		}
		
		FitnessEvent tempFitnessEvent=fitnessEventDAO.getById(fitnessEventId);
		
		if(!tempFitnessEvent.getUsers().contains(theUser)) {
			throw new NoSuchAUserOnFitnessEventListException("There is no such a user on the fitness event list.");
		}
		
		if(tempFitnessEvent.getStartTime().minusHours(1).isBefore(LocalDateTime.now()) && tempFitnessEvent.getStartTime().isAfter(LocalDateTime.now())) {
			throw new UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts();
		}
		
		if(tempFitnessEvent.getStartTime().isBefore(LocalDateTime.now())) {
			throw new UserCanNotCancelParticipationFromPastFitnessEventsException();
		}
		
		tempFitnessEvent.getUsers().remove(theUser);
		
		try {
			fitnessEventDAO.update(tempFitnessEvent);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
		return false;
	}
	
}
