package com.myprojects.gza.myGymApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainers")
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image")
	private String image;
	
	public Trainer() {}
	
	public Trainer(int id, String name, String surname, String description, String image) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.description = description;
		this.image = image;
	}
	
	public Trainer(String name, String surname, String description, String image) {
		this.name = name;
		this.surname = surname;
		this.description = description;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", surname=" + surname + ", description=" + description
				+ ", image=" + image + "]";
	}
}
