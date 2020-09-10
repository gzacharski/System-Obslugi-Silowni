package com.myprojects.gza.myGymApp.errors;

public class MaxNumberOfPeopleInTheFitnessEventException extends SigningUpToFitnessEventException {

	private static final long serialVersionUID = 862233743637031162L;

	public MaxNumberOfPeopleInTheFitnessEventException() {
		super();
	}

	public MaxNumberOfPeopleInTheFitnessEventException(String message) {
		super(message);
	}
}
