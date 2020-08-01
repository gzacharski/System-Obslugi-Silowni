package com.myprojects.gza.myGymApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprojects.gza.myGymApp.entity.Workout;
import com.myprojects.gza.myGymApp.service.WorkoutService;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/list")
	public String showWorkouts(Model model) {
		List<Workout> workouts=workoutService.getWorkouts();
		
		model.addAttribute("workouts", workouts);
		
		return "workouts";
	}
}
