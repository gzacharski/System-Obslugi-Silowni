package com.myprojects.gza.myGymApp.helperClasses;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@DisplayName("Test cases for NewUser.class")
class NewUserTest {
	
	@Test
	@DisplayName("Simulate creating account")
	void newUserShouldNotBeNullAfterBeingSet() {
		//given
		NewUser newUser=new NewUser();
		
		//when
		newUser.setName("Grzegorz");
		newUser.setSurname("Zacharski");
		newUser.setEmail("g.zacharski@wp.pl");
		newUser.setPassword("abcd1234");
		newUser.setMatchingPassword("abcd1234");
		
		//then
		assertNotNull(newUser);
		assertThat(newUser).isNotNull();
	}
	
}
