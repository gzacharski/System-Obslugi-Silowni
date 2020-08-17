package com.myprojects.gza.myGymApp.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_address_id")
	private UserAddress userAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_agreements_id")
	private UserAgreements userAgreements;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private Collection<Role> roles;
	
	public User() {}
	
	public User(int id, String name, String surname, String email, String telephone, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
	}

	public User(String name, String surname, String email, String telephone, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone=telephone;
		this.password = password;
	}
	
	public User(String name, String surname, String email, String telephone) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone=telephone;
	}

	public User(int id, String name, String surname, String email, String telephone, String password,
			UserDetails userDetails, UserAddress userAddress, UserAgreements userAgreements, Collection<Role> roles) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.userDetails = userDetails;
		this.userAddress = userAddress;
		this.userAgreements = userAgreements;
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public UserAgreements getUserAgreements() {
		return userAgreements;
	}

	public void setUserAgreements(UserAgreements userAgreements) {
		this.userAgreements = userAgreements;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", telephone="
				+ telephone + ", password=" + password + ", userDetails=" + userDetails + ", userAddress=" + userAddress
				+ ", userAgreements=" + userAgreements + ", roles=" + roles + "]";
	}
}
