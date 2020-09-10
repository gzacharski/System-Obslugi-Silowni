package com.myprojects.gza.myGymApp.entity;

import javax.annotation.Nonnegative;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.myprojects.gza.myGymApp.validation.AcceptableiImageFileExtension;

@Entity
@Table(name="gym_equipments")
public class Equipment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Nonnegative
	@Min(value = 1)
	@Max(value = 99)
	@Column(name="quantity")
	private int quantity;
	
	@Column(name = "description")
	private String description;
	
	@AcceptableiImageFileExtension
	@Column(name="photo")
	private String photo;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	public Equipment() {}
	
	public Equipment(@NotNull @Nonnegative int quantity, String description, @AcceptableiImageFileExtension String photo, @NotNull String name) {
		this.quantity = quantity;
		this.description = description;
		this.photo = photo;
		this.name = name;
	}

	public Equipment(int id, @NotNull @Nonnegative int quantity, String description, @AcceptableiImageFileExtension String photo, @NotNull String name) {
		this.id = id;
		this.quantity = quantity;
		this.description = description;
		this.photo = photo;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", quantity=" + quantity + ", description=" + description + ", photo=" + photo
				+ ", name=" + name + "]";
	}	
}
