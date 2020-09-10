package com.myprojects.gza.myGymApp.errors;

import com.myprojects.gza.myGymApp.entity.RemovalOfUserFromFitnessEventException;

public class UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts
		extends RemovalOfUserFromFitnessEventException {

	private static final long serialVersionUID = 8615931756439656942L;

	public UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts() {
		super();
	}

	public UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts(String message, Throwable cause) {
		super(message, cause);
	}

	public UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts(String message) {
		super(message);
	}
}
