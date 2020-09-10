package com.myprojects.gza.myGymApp.errors;

public abstract class SigningUpToFitnessEventException extends Exception {

	private static final long serialVersionUID = -4579997832437069869L;

	public SigningUpToFitnessEventException() {
		super();
	}

	public SigningUpToFitnessEventException(String message) {
		super(message);
	}

	public SigningUpToFitnessEventException(String message, Throwable cause) {
		super(message, cause);
	}
}
