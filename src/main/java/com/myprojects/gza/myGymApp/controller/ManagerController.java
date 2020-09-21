package com.myprojects.gza.myGymApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/manager")
public class ManagerController {
	
	@GetMapping("/main")
	public String showMainPage() {
		return "manager/main-page";
	}
	
	@GetMapping("/function")
	public String showErrorPage() {
		return "errors/error-404";
	}
}
