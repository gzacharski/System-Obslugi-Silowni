package com.myprojects.gza.myGymApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gym_equipments")
public class Equipment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="photo")
	private String photo;
	
	public Equipment() {}

	public Equipment(int id, int quantity, String description, String photo) {
		this.id = id;
		this.quantity = quantity;
		this.description = description;
		this.photo = photo;
	}

	public Equipment(int quantity, String description, String photo) {
		this.quantity = quantity;
		this.description = description;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentId=" + id + ", quantity=" + quantity + ", description=" + description
				+ ", photo=" + photo + "]";
	}
}
