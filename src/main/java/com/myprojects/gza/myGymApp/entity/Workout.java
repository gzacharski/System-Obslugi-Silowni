package com.myprojects.gza.myGymApp.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workouts")
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type_of_workout")
	private String typeOfWorkout;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image")
	private String image;
	
	@Column(name="duration")
	private Time duration;
	
	public Workout() {};
	
	public Workout(String typeOfWorkout, String description, String image, Time duration) {
		this.typeOfWorkout = typeOfWorkout;
		this.description = description;
		this.image = image;
		this.duration = duration;
	}

	public Workout(int id, String typeOfWorkout, String description, String image, Time duration) {
		this.id = id;
		this.typeOfWorkout = typeOfWorkout;
		this.description = description;
		this.image = image;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeOfWorkout() {
		return typeOfWorkout;
	}

	public void setTypeOfWorkout(String typeOfWorkout) {
		this.typeOfWorkout = typeOfWorkout;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Workout [typeOfWorkout=" + typeOfWorkout + ", description=" + description
				+ ", image=" + image + ", duration=" + duration.toString() + "]";
	}
}	
