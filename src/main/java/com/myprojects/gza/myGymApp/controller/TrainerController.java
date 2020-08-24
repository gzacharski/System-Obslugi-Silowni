package com.myprojects.gza.myGymApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/trainer")
public class TrainerController {
	
	@GetMapping("/main")
	public String showMainPage() {
		return "trainer/main-page";
	}
}
