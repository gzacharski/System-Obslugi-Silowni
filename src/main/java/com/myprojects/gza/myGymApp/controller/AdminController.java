package com.myprojects.gza.myGymApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myprojects.gza.myGymApp.entity.User;
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
		
		List<User> users=userService.getAllUsers();
		
		System.out.println(users.toString());
		
		model.addAttribute("users", users);
		
		return "admin/user-list";
	}
	
	@GetMapping("/editUser")
	public String showEditUser(@RequestParam("userId") int userId, Model model) {
		
		User theUser=userService.getById(userId);
		
		model.addAttribute("user", theUser);
		
		return "admin/edit-user";
	}
	
	@PostMapping("/editUser/save")
	public String saveOrUpdateUserCredentials(@ModelAttribute("user") User theUser, Model theModel) {
		
		User tempUser=userService.getById(theUser.getId());
		
		System.out.println(tempUser.toString());
		
		tempUser.setName(theUser.getName());
		tempUser.setSurname(theUser.getSurname());
		tempUser.setEmail(theUser.getEmail());
		
		System.out.println(tempUser.toString());
		
		userService.save(tempUser);
		
		theModel.addAttribute("hasBeenSaved", true);
		
		return "admin/edit-user";
	}
}
