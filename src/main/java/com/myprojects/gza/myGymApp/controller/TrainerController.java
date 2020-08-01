package com.myprojects.gza.myGymApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprojects.gza.myGymApp.service.TrainerService;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@GetMapping("/list")
	public String showTrainers() {
		return "trainers";
	}
}
