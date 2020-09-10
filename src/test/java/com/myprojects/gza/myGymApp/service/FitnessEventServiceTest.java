package com.myprojects.gza.myGymApp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;


class FitnessEventServiceTest {

	@Test
	void methodShouldAlwaysReturnMonday() {
		//given
		LocalDate currentDay=LocalDate.now();
		
		//when
		LocalDate monday=currentDay.minusDays(currentDay.getDayOfWeek().getValue()-1);
		
		//then
		assertThat(monday.getDayOfWeek()).isEqualTo(DayOfWeek.MONDAY);
	}
	
	@Test
	void methodShouldAlwaysReturnSunday() {
		//given
		LocalDate currentDay=LocalDate.now();
		
		//when
		LocalDate sunday=currentDay.plusDays(7-currentDay.getDayOfWeek().getValue());
		
		//then
		assertThat(sunday.getDayOfWeek()).isEqualTo(DayOfWeek.SUNDAY);
	}
	
	@Test
	void methodShouldReturnOnlyEventsInSpecifiedWeek() {
		//given
		
		//when
		
		//then
		
	}

}
