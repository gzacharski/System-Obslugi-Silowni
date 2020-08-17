package com.myprojects.gza.myGymApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprojects.gza.myGymApp.service.UserService;

@Controller
@RequestMapping("/user/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/main")
	public String showMainPage() {
		return "admin/main-page";
	}
	
	@GetMapping("/listOfUsers")
	public String showUsersList(Model model) {
		
		return "admin/user-list";
	}
}
