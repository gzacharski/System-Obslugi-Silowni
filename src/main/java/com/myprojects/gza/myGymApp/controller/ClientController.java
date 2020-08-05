package com.myprojects.gza.myGymApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@GetMapping("/workouts")
	public String showWorkouts() {
		return "client-workouts";
	}
	
	@GetMapping("/main")
	public String showMainPage() {
		return "client-main-page";
	}

}
