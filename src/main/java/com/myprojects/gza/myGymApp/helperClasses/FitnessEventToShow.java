package com.myprojects.gza.myGymApp.helperClasses;

import java.sql.Time;
import java.time.LocalDateTime;

import com.myprojects.gza.myGymApp.entity.FitnessEvent;

public class FitnessEventToShow extends FitnessEvent {
	private String workoutImage;
	private String typeOfWorkout;
	private Time workoutDuration;
	private String trainerName;
	private String trainerSurname;
	private String placeName;
	


	public FitnessEventToShow(int classId, LocalDateTime startTime, int maxPeople, String description, int trainerId,
			int workoutId, int placeId, String workoutImage, String typeOfWorkout, Time workoutDuration,
			String trainerName, String trainerSurname, String placeName) {
		
		super(classId, startTime, maxPeople, description, trainerId, workoutId, placeId);
		this.workoutImage = workoutImage;
		this.typeOfWorkout = typeOfWorkout;
		this.workoutDuration = workoutDuration;
		this.trainerName = trainerName;
		this.trainerSurname = trainerSurname;
		this.placeName = placeName;
	}

	public String getWorkoutImage() {
		return workoutImage;
	}

	public void setWorkoutImage(String workoutImage) {
		this.workoutImage = workoutImage;
	}

	public String getTypeOfWorkout() {
		return typeOfWorkout;
	}

	public void setTypeOfWorkout(String typeOfWorkout) {
		this.typeOfWorkout = typeOfWorkout;
	}

	public Time getWorkoutDuration() {
		return workoutDuration;
	}

	public void setWorkoutDuration(Time workoutDuration) {
		this.workoutDuration = workoutDuration;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerSurname() {
		return trainerSurname;
	}

	public void setTrainerSurname(String trainerSurname) {
		this.trainerSurname = trainerSurname;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
}
