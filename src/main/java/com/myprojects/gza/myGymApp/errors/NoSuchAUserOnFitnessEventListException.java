package com.myprojects.gza.myGymApp.errors;

import com.myprojects.gza.myGymApp.entity.RemovalOfUserFromFitnessEventException;

public class NoSuchAUserOnFitnessEventListException extends RemovalOfUserFromFitnessEventException {

	private static final long serialVersionUID = -7061882074095527334L;

	public NoSuchAUserOnFitnessEventListException() {
		super();
	}

	public NoSuchAUserOnFitnessEventListException(String message) {
		super(message);
	}
}
