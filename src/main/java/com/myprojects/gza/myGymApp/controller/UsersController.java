package com.myprojects.gza.myGymApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.service.UserService;

@Controller
@RequestMapping("/user/users")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String showUsers(Model model) {
		
		List<User> users=userService.getAllUsers();
		
		model.addAttribute("users", users);
		
		return "users/list";
	}
	
	@GetMapping("/search")
	public String searchUser(@RequestParam("searchedPhrase") String searchedPhrase, Model model) {
		
		List<User> users=userService.search(searchedPhrase);
		
		model.addAttribute("users", users);
		
		if(users==null || users.size()==0) {
			model.addAttribute("warning", "Nie znaleziono podanej frazy :(");
		}else {
			model.addAttribute("info", "Znaleziono " +users.size() + " pasujących rezultatów");
		}
		
		return "users/list";
	}
}
