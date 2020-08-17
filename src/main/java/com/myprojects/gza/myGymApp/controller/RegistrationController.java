package com.myprojects.gza.myGymApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.helperClasses.NewUser;
import com.myprojects.gza.myGymApp.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/form")
	public String showRegistrationForm(Model model) {
		
		model.addAttribute("newUser",new NewUser());
		return "registration-form";
	}
	
	@PostMapping("/process")
	public String processRegistrationForm(@Valid @ModelAttribute("newUser") NewUser newUser,
			BindingResult bindingResult, Model model) {
		
		String userEmail=newUser.getEmail();
		
		//form validation
		if(bindingResult.hasErrors()) {
			return "registration-form";
		}
		
		User existingUser=userService.findByEmail(userEmail);
		
		if(existingUser!=null) {
			
			NewUser currentUser=new NewUser();
			
			currentUser.setName(newUser.getName());
			currentUser.setSurname(newUser.getSurname());
			currentUser.setEmail(newUser.getEmail());
			currentUser.setTelephoneNumber(newUser.getTelephoneNumber());
			
			model.addAttribute("newUser",currentUser);
			model.addAttribute("registrationError","User email already exists");
			
			return "registration-form";
		}
		
		userService.save(newUser);
		
		return "registration-confirmation";
	}
	
}
