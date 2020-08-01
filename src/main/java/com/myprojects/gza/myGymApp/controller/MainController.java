package com.myprojects.gza.myGymApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/fitnessEvents")
	public String showFitnessEvents() {
		return "fitnessEvents";
	}
	
	@GetMapping("/client")
	public String showClient() {
		return "client-logging-page";
	}
	
}
