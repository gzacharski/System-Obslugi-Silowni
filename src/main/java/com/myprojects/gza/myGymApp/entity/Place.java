package com.myprojects.gza.myGymApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="places")
public class Place {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="place_name")
	private String placeName;
	
	@Column(name = "description")
	private String description;
	
	public Place() {}

	public Place(String placeName, String description) {
		this.placeName = placeName;
		this.description = description;
	}

	public Place(int id, String placeName, String description) {
		this.id = id;
		this.placeName = placeName;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", placeName=" + placeName + ", description=" + description + "]";
	}
	
	
}
