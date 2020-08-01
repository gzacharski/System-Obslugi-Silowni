package com.myprojects.gza.myGymApp.service;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.Trainer;

public interface TrainerService {
	List<Trainer> getTrainers();
	Trainer getTrainer(int trainerId);
	void deleteTrainer(int trainerId);
}
