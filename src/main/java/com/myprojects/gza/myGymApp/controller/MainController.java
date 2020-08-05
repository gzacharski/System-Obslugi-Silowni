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
	
	@GetMapping("/logIn")
	public String showLogIn() {
		return "log-in";
	}
	
	@GetMapping("/signUp")
	public String showSignUp() {
		return "sign-up";
	}
	
}
