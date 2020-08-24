package com.myprojects.gza.myGymApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myprojects.gza.myGymApp.entity.Trainer;
import com.myprojects.gza.myGymApp.entity.Workout;
import com.myprojects.gza.myGymApp.service.TrainerService;
import com.myprojects.gza.myGymApp.service.WorkoutService;

@Controller
public class MainController {
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/fitnessEvents")
	public String showFitnessEvents() {
		return "fitnessEvents";
	}
	
	@GetMapping("/logIn")
	public String showLogIn() {
		return "log-in";
	}
	
//	@GetMapping("/signUp")
//	public String showSignUp() {
//		return "sign-up";
//	}
	
	@GetMapping("/trainers/list")
	public String showTrainers(Model model) {
		
		List<Trainer> trainers=trainerService.getTrainers();
		
		model.addAttribute("trainers", trainers);
		
		System.out.println(trainers.toString());
		
		//return "trainers";
		return showIndex();
	}
	
	@GetMapping("/workouts/list")
	public String showWorkouts(Model model) {
		List<Workout> workouts=workoutService.getWorkouts();
		
		model.addAttribute("workouts", workouts);
		
		return "workouts";
	}
	
}
