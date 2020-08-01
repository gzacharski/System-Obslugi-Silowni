package com.myprojects.gza.myGymApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
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
	@JoinColumn(name = "client_details_id")
	private ClientDetails clientDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_address_id")
	private ClientAddress clientAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="client_agreements_id")
	private ClientAgreements clientAgreements;
	
	public Client() {}
	
	public Client(int id, String name, String surname, String email, String telephone, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
	}

	public Client(String name, String surname, String email, String telephone, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone=telephone;
		this.password = password;
	}
	
	public Client(String name, String surname, String email, String telephone) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone=telephone;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public ClientAddress getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(ClientAddress clientAddress) {
		this.clientAddress = clientAddress;
	}

	public ClientAgreements getClientAgreements() {
		return clientAgreements;
	}

	public void setClientAgreements(ClientAgreements clientAgreements) {
		this.clientAgreements = clientAgreements;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", telephone="
				+ telephone + ", password=" + password + ", clientDetails=" + clientDetails + ", clientAddress="
				+ clientAddress + ", clientAgreements=" + clientAgreements + "]";
	}
	
}
