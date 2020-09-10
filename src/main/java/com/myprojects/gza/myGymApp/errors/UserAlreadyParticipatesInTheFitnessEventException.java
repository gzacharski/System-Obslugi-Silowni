package com.myprojects.gza.myGymApp.errors;

public class UserAlreadyParticipatesInTheFitnessEventException extends SigningUpToFitnessEventException {

	private static final long serialVersionUID = -6077280623467707161L;

	public UserAlreadyParticipatesInTheFitnessEventException() {
		super();
	}

	public UserAlreadyParticipatesInTheFitnessEventException(String message) {
		super(message);
	}
}
