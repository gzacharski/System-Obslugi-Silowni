package com.myprojects.gza.myGymApp.helperClasses;

import java.util.Comparator;

public class FitnessEventDateComparator implements Comparator<FitnessEventToShow>{

	@Override
	public int compare(FitnessEventToShow o1, FitnessEventToShow o2) {
		return o1.getStartTime().compareTo(o2.getStartTime());
	}

}
