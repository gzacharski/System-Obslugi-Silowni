package com.myprojects.gza.myGymApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
	
	@GetMapping("/list")
	public String showTrainers() {
		return "trainers";
	}
}
