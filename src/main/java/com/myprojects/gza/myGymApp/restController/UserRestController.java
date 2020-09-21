package com.myprojects.gza.myGymApp.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.helperClasses.View;
import com.myprojects.gza.myGymApp.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@JsonView(View.Summary.class)
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@JsonView(View.Details.class)
	@GetMapping("/users/{id}")
	public User getTheUser(@PathVariable(name = "id") int id){
		
		User theUser=null;
		
		try {
			theUser=userService.getAllUserInfoById(id);
		}catch(Exception e) {
			throw new UserNotFoundException("User not found - " + id);
		}
		
		return theUser;
	}
	
	@JsonView(View.Details.class)
	@GetMapping("/users/details")
	public List<User> getAllUsersWithDetails(){
		return userService.getAllUsers();
	}
}
