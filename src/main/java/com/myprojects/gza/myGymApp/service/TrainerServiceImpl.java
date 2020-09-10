package com.myprojects.gza.myGymApp.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.gza.myGymApp.dao.RoleDAO;
import com.myprojects.gza.myGymApp.dao.TrainerDAO;
import com.myprojects.gza.myGymApp.dao.UserDAO;
import com.myprojects.gza.myGymApp.entity.Role;
import com.myprojects.gza.myGymApp.entity.Trainer;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.helperClasses.Roles;

@Service
public class TrainerServiceImpl implements TrainerService{
	
	@Autowired
	private TrainerDAO trainerDAO;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@Override
	@Transactional
	public List<Trainer> getTrainers() {
		List<Trainer> trainers=trainerDAO.getTrainers();
		
		trainers.stream().forEach(trainer -> Hibernate.initialize(trainer.getUser()));
		
		return trainers;
	}

	@Override
	@Transactional
	public Trainer getTrainer(int trainerId) {
		Trainer tempTrainer=trainerDAO.getTrainer(trainerId);
		
		Hibernate.initialize(tempTrainer.getUser());
		return tempTrainer;
	}

	@Override
	@Transactional
	public void deleteTrainer(int trainerId) {
		
		User tempUser=trainerDAO.getTrainer(trainerId).getUser();
		
		Role trainerRole=roleDao.findRoleByName(Roles.ROLE_TRAINER.toString());
		
		System.out.println("====> " +tempUser.toString());
		
		tempUser.getRoles().remove(trainerRole);
		
		System.out.println(tempUser.toString());
		
		trainerDAO.deleteTrainer(trainerId);
	}

	@Override
	@Transactional
	public List<Trainer> searchTrainer(String searchedPhrase) {

		return trainerDAO.searchTrainer(searchedPhrase);
	}

	@Override
	@Transactional
	public boolean addNewTrainer(Trainer newTrainer) {
		
		if(newTrainer==null) return false;
		
		User tempUser=userDao.getById(newTrainer.getUser().getId());
		
		newTrainer.setUser(tempUser);
		
		try {
			trainerDAO.saveTrainer(newTrainer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public boolean updateTrainer(Trainer trainer) {
		
		if(trainer==null) return false;
		
		User tempUser=userDao.getById(trainer.getUser().getId());
		
		trainer.setUser(tempUser);
		
		try {
			trainerDAO.updateTrainer(trainer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional
	public Map<Integer, String> getAllTrainersMappedById() {
		
		return trainerDAO.getTrainers().stream()
				.collect(Collectors.toMap(
						trainer -> trainer.getId(), 
						trainer -> trainer.getUser().getName()+" "+trainer.getUser().getSurname()
						));
	}

}
