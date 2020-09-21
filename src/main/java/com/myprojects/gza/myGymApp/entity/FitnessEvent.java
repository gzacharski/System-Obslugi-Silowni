package com.myprojects.gza.myGymApp.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="fitness_events")
public class FitnessEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="start_time")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@NotNull(message = "Pole musi zostać wypełnione")
	private LocalDateTime startTime;
	
	@Column(name="max_people")
	@NotNull(message = "Pole musi zostać wypełnione")
	private int maxPeople;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH}, 
			fetch = FetchType.EAGER)
	@JoinColumn(name="trainer_id")
	@NotNull(message = "Pole musi zostać wypełnione")
	private Trainer trainer;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH}, 
			fetch = FetchType.EAGER)
	@JoinColumn(name="workout_id")
	@NotNull(message = "Pole musi zostać wypełnione")
	private Workout workout;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH}, 
			fetch = FetchType.EAGER)
	@JoinColumn(name="place_id")
	@NotNull(message = "Pole musi zostać wypełnione")
	private Place place;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name= "attendance_list", joinColumns = @JoinColumn(name = "fitness_event_id"), 
			inverseJoinColumns = @JoinColumn(name="user_id"))
	private Collection<User> users;
	
	public FitnessEvent() {}

	public FitnessEvent(int id, LocalDateTime startTime, int maxPeople, String description, Trainer trainer,
			Workout workout, Place place) {
		this.id = id;
		this.startTime = startTime;
		this.maxPeople = maxPeople;
		this.description = description;
		this.trainer = trainer;
		this.workout = workout;
		this.place = place;
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

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "FitnessEvent [id=" + id + ", startTime=" + startTime + ", maxPeople=" + maxPeople + ", description="
				+ description + ", trainer=" + trainer + ", workout=" + workout + ", place=" + place + "]";
	}
}
