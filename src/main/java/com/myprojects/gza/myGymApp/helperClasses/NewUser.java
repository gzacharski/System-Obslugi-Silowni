package com.myprojects.gza.myGymApp.helperClasses;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.myprojects.gza.myGymApp.validation.FieldMatch;
import com.myprojects.gza.myGymApp.validation.ValidEmail;
import com.myprojects.gza.myGymApp.validation.ValidTelephoneNumber;

@FieldMatch.List({
	@FieldMatch(firstField = "password", secondField = "matchingPasword", message = "The password fields must match.")
})
public class NewUser {
	@NotNull(message ="Field is required.")
	@Size(min = 3, max = 32, message = "Field is required. Type from 3 to 32 characters.")
	private String name;
	
	@NotNull(message ="Field is required.")
	@Size(min = 3, max = 32, message = "Field is required. Type from 3 to 32 characters.")
	private String surname;
	
	@ValidTelephoneNumber(message = "Field is optional")
	private String telephoneNumber;
	
	@NotNull(message ="Field is required.")
	@Size(min = 8, max = 32,  message = "Password must have from 8 to 32 characters.")
	private String password;
	
	@NotNull(message ="Field is required.")
	@Size(min = 1, message = "Password must be the same.")
	private String matchingPassword;
	
	@ValidEmail
	@NotNull(message ="Field is required.")
	@Size(min = 1, message = "Type your email address.")
	private String email;
	
	public NewUser() {}

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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
