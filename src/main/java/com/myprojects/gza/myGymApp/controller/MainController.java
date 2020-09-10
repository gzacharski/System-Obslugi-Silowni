package com.myprojects.gza.myGymApp.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myprojects.gza.myGymApp.captcha.ICaptchaService;
import com.myprojects.gza.myGymApp.entity.Equipment;
import com.myprojects.gza.myGymApp.entity.FitnessEvent;
import com.myprojects.gza.myGymApp.entity.Trainer;
import com.myprojects.gza.myGymApp.entity.Workout;
import com.myprojects.gza.myGymApp.service.EquipmentService;
import com.myprojects.gza.myGymApp.service.FitnessEventService;
import com.myprojects.gza.myGymApp.service.TrainerService;
import com.myprojects.gza.myGymApp.service.WorkoutService;

@Controller
public class MainController {
	
	@Autowired
	private ICaptchaService captchaService;
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private FitnessEventService fitnessEventService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/fitnessEvents")
	public String showFitnessEvents(Model model) {
		
		LocalDate localDate=LocalDate.now();
		
		addToModelFitnessEventsInSelectedWeek(localDate, model);
		
		return "fitnessEvents";
	}
	
	@PostMapping("/fitnessEvents/nextWeek")
	public String showFitnessEventsInNextWeek(@ModelAttribute("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate, Model model) {
		
		localDate=localDate.plusDays(7);

		addToModelFitnessEventsInSelectedWeek(localDate, model);
		 
		return "fitnessEvents";
	}

	@PostMapping("/fitnessEvents/previousWeek")
	public String showFitnessEventsInPreviousWeek(@ModelAttribute("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate, Model model) {
		
		localDate=localDate.minusDays(7);

		addToModelFitnessEventsInSelectedWeek(localDate, model);
		
		return "fitnessEvents";
	}
	
	private void addToModelFitnessEventsInSelectedWeek(LocalDate localDate, Model model) {
		
		List<FitnessEvent> fitnessEvents=fitnessEventService.getAllEventsInSpecifiedWeek(localDate);
	  
		model.addAttribute("events", fitnessEvents);
	  
		setDateParameters(model, localDate);
	}
	
	private void setDateParameters(Model model, LocalDate localDate) {
		
		model.addAttribute("selectedDate",localDate);
		model.addAttribute("mondayOfCurrentWeek",localDate.minusDays(localDate.getDayOfWeek().getValue()-1));
		model.addAttribute("sundayOfCurrentWeek", localDate.plusDays(7-localDate.getDayOfWeek().getValue()));
		model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
	}
	
	@GetMapping("/logIn")
	public String showLogIn(Model model) {
		
		String site=captchaService.getReCaptchaSite();
		model.addAttribute("siteKey", site);
		
		return "log-in";
	}
	
	@GetMapping("/trainers/list")
	public String showTrainers(Model model) {
		
		List<Trainer> trainers=trainerService.getTrainers();
		
		model.addAttribute("trainers", trainers);
		
		System.out.println(trainers.toString());
		
		return "trainers";
	}
	
	@GetMapping("/workouts/list")
	public String showWorkouts(Model model) {
		List<Workout> workouts=workoutService.getWorkouts();
		
		model.addAttribute("workouts", workouts);
		
		return "workouts";
	}
	
	@GetMapping("/equipment")
	public String showEquipment(Model model) {
		
		List<Equipment> equipments=equipmentService.getAll();
		
		if(equipments.size()==0) {
			model.addAttribute("info", "Brak dodanego sprzętu.");
		}
		
		model.addAttribute("equipments", equipments);
		
		return "equipments";
	}
}
