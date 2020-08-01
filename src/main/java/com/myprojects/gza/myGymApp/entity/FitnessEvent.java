package com.myprojects.gza.myGymApp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fitness_events")
public class FitnessEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="start_time")
	private LocalDateTime startTime;
	
	@Column(name="max_people")
	private int maxPeople;
	
	@Column(name="description")
	private String description;
	
	@Column(name="trainer_id")
	private int trainerId;
	
	@Column(name="workout_id")
	private int workoutId;
	
	@Column(name="place_id")
	private int placeId;
	
	public FitnessEvent(int id, LocalDateTime startTime, int maxPeople, String description, int trainerId, int workoutId,
			int placeId) {
		this.id = id;
		this.startTime = startTime;
		this.maxPeople = maxPeople;
		this.description = description;
		this.trainerId = trainerId;
		this.workoutId = workoutId;
		this.placeId = placeId;
	}
	
	public FitnessEvent(LocalDateTime startTime, int maxPeople, String description, int trainerId, int workoutId, int placeId) {
		this.startTime = startTime;
		this.maxPeople = maxPeople;
		this.description = description;
		this.trainerId = trainerId;
		this.workoutId = workoutId;
		this.placeId = placeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	@Override
	public String toString() {
		return "FitnessEvent [startTime=" + startTime.toString() + ", maxPeople=" + maxPeople + ", description=" + description
				+ ", trainerId=" + trainerId + ", workoutId=" + workoutId + ", placeId=" + placeId + "]";
	}
}
