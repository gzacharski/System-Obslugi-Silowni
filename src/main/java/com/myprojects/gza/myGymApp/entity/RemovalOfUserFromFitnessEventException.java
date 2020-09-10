package com.myprojects.gza.myGymApp.entity;

public abstract class RemovalOfUserFromFitnessEventException extends Exception {

	private static final long serialVersionUID = 6015648355273901463L;

	public RemovalOfUserFromFitnessEventException() {
		super();
	}

	public RemovalOfUserFromFitnessEventException(String message, Throwable cause) {
		super(message, cause);
	}

	public RemovalOfUserFromFitnessEventException(String message) {
		super(message);
	}
}
