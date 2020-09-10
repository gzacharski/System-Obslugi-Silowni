package com.myprojects.gza.myGymApp.errors;

public class ThereIsNoSuchAnEquipmentException extends Exception {

	private static final long serialVersionUID = -6826250089116801443L;

	public ThereIsNoSuchAnEquipmentException() {
		super();
	}

	public ThereIsNoSuchAnEquipmentException(String message) {
		super(message);
	}
}
