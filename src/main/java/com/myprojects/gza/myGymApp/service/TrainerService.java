package com.myprojects.gza.myGymApp.service;

import java.util.List;
import java.util.Map;

import com.myprojects.gza.myGymApp.entity.Trainer;
import com.myprojects.gza.myGymApp.entity.User;

public interface TrainerService {
	List<Trainer> getTrainers();
	Trainer getTrainer(int trainerId);
	void deleteTrainer(int trainerId);
	List<Trainer> searchTrainer(String searchedPhrase);
	boolean addNewTrainer(Trainer newTrainer);
	boolean updateTrainer(Trainer trainer);
	Map<Integer, String> getAllTrainersMappedById();
}
