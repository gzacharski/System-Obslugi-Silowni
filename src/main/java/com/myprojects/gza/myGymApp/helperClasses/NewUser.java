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
	@NotNull(message ="Imię użytkownika jest wymagane.")
	@Size(min = 2, max = 32, message = "Imię użytkownika powinno zawierać od 2 do 32 znaków.")
	private String name;
	
	@NotNull(message ="Nazwisko użytkownika jest wymagane.")
	@Size(min = 2, max = 32, message = "Nazwisko użytkownika powinno zawierać od 2 do 32 znaków.")
	private String surname;
	
	@ValidTelephoneNumber(message = "To pole jest opcjonalne. Numer telefonu powinien mieć 9 cyfr.")
	private String telephoneNumber;
	
	@NotNull(message ="Podanie hasła jest wymagane.")
	@Size(min = 8, max = 32,  message = "Hasło musi zawierać od 8 do 32 znaków.")
	private String password;
	
	@NotNull(message ="Ponowne podanie hasła jest wymagane.")
	@Size(min = 8, max = 32, message = "Podane hasła muszą być identyczne.")
	private String matchingPassword;
	
	@ValidEmail
	@NotNull(message ="Adres email jest wymagany.")
	@Size(min = 3, message = "Wpisz swój adres email.")
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
