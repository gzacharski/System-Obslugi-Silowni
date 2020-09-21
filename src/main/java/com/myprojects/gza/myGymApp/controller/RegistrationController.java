package com.myprojects.gza.myGymApp.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.myprojects.gza.myGymApp.captcha.ICaptchaService;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.helperClasses.NewUser;
import com.myprojects.gza.myGymApp.service.UserService;
import com.myprojects.gza.myGymApp.util.GenericResponse;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private static final Logger LOGGER=Logger.getLogger(RegistrationController.class.getCanonicalName());
	
	@Autowired
	private ICaptchaService captchaService;
	
	@Autowired
	private MainController mainController;
	
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
		return addCaptchaToRegistrationForm(model);
	}
	
	@PostMapping("/process")
	public String processRegistrationForm(@Valid @ModelAttribute("newUser") NewUser newUser,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		
		String responseCaptcha=request.getParameter("g-recaptcha-response");
		captchaService.processResponse(responseCaptcha);
		
		String userEmail=newUser.getEmail();
		
		//form validation
		if(bindingResult.hasErrors()) {
			return addCaptchaToRegistrationForm(model);
		}
		
		
		User existingUser=userService.findByEmail(userEmail);
		
		if(existingUser!=null) {
			
			NewUser currentUser=new NewUser();
			
			currentUser.setName(newUser.getName());
			currentUser.setSurname(newUser.getSurname());
			currentUser.setEmail(newUser.getEmail());
			currentUser.setTelephoneNumber(newUser.getTelephoneNumber());
			
			model.addAttribute("newUser",currentUser);
			model.addAttribute("registrationError","Użytkownik o podanym adresie email już istnieje.");
			
			return addCaptchaToRegistrationForm(model);
		}
		
		userService.save(newUser);
		
		model.addAttribute("register",true);
		
		return mainController.showLogIn(model);
	}

	private String addCaptchaToRegistrationForm(Model model) {
		
		String site=captchaService.getReCaptchaSite();
		model.addAttribute("siteKey", site);
		
		return "registration-form";
	}
	
	@GetMapping("/function")
	public String showErrorPage() {
		return "errors/error-404";
	}
}
