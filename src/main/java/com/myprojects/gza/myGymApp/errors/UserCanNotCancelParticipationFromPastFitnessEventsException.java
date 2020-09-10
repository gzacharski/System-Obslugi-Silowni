package com.myprojects.gza.myGymApp.errors;

public class UserCanNotCancelParticipationFromPastFitnessEventsException extends RemovalOfUserFromFitnessEventException {

	private static final long serialVersionUID = -3213464197078833504L;

	public UserCanNotCancelParticipationFromPastFitnessEventsException() {
		super();
	}

	public UserCanNotCancelParticipationFromPastFitnessEventsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserCanNotCancelParticipationFromPastFitnessEventsException(String message) {
		super(message);
	}
}
