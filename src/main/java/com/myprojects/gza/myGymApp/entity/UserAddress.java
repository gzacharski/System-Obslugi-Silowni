package com.myprojects.gza.myGymApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_address")
public class UserAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="street")
	private String street;
	
	@Column(name="home_number")
	private String homeNumber;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="city")
	private String city;
	
	@OneToOne(mappedBy = "userAddress", 
			cascade = {CascadeType.DETACH, CascadeType.MERGE, 
					CascadeType.PERSIST, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	private User user;
	
	public UserAddress() {}

	public UserAddress(String street, String homeNumber, String postalCode, String city) {
		this.street = street;
		this.homeNumber = homeNumber;
		this.postalCode = postalCode;
		this.city = city;
	}

	public UserAddress(int id, String street, String homeNumber, String postalCode, String city) {
		this.id = id;
		this.street = street;
		this.homeNumber = homeNumber;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getHomeNumber() {
		return homeNumber;
	}
	
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", street=" + street + ", homeNumber=" + homeNumber + ", postalCode="
				+ postalCode + ", city=" + city + "]";
	}

}
