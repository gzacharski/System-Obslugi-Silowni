package com.myprojects.gza.myGymApp.dao;

import java.util.List;

import com.myprojects.gza.myGymApp.entity.Trainer;

public interface TrainerDAO {
	List<Trainer> getTrainers();
	Trainer getTrainer(int trainerId);
	void deleteTrainer(int trainerId);
	List<Trainer> searchTrainer(String searchedPhrase);
	boolean saveTrainer(Trainer trainer);
	boolean updateTrainer(Trainer trainer);
}
