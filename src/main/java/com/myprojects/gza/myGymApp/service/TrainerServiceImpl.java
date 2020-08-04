package com.myprojects.gza.myGymApp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.gza.myGymApp.dao.TrainerDAO;
import com.myprojects.gza.myGymApp.entity.Trainer;

@Service
public class TrainerServiceImpl implements TrainerService{
	
	@Autowired
	private TrainerDAO trainerDAO;
	
	@Override
	@Transactional
	public List<Trainer> getTrainers() {
		List<Trainer> trainers=trainerDAO.getTrainers();
		return trainers;
	}

	@Override
	@Transactional
	public Trainer getTrainer(int trainerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteTrainer(int trainerId) {
		// TODO Auto-generated method stub
		
	}

}
