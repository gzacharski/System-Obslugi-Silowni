package com.myprojects.gza.myGymApp.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myprojects.gza.myGymApp.entity.FitnessEvent;
import com.myprojects.gza.myGymApp.service.FitnessEventService;
import com.myprojects.gza.myGymApp.service.PlaceService;
import com.myprojects.gza.myGymApp.service.TrainerService;
import com.myprojects.gza.myGymApp.service.WorkoutService;

@Controller
@RequestMapping("user/events")
public class FitnessEventController {
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private FitnessEventService fitnessEventService;
	
	@GetMapping("/")
	public String showFitnessEvents(Model model) {
		
		List<FitnessEvent> fitnessEvents=fitnessEventService.getAll();
		
		model.addAttribute("events", fitnessEvents);
		model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		
		return "fitness-event/list";
	}
	
	@GetMapping("/add")
	public String showFormToAddFitnessEvent(Model model) {
		
		Map<Integer, String> workouts=workoutService.getAllTypesOfWorkoutMappedById();
		Map<Integer, String> trainers=trainerService.getAllTrainersMappedById();
		Map<Integer, String> places=placeService.getAllPlacesMappedById();
		
		model.addAttribute("workouts", workouts);
		model.addAttribute("trainers", trainers);
		model.addAttribute("places", places);
		model.addAttribute("fitnessEvent", new FitnessEvent());

		return "fitness-event/add";
	}
	
	@PostMapping("/add")
	public String saveFormToAddFitnessEvent(@Valid @ModelAttribute("fitnessEvent") FitnessEvent fitnessEvent, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) addErrorsToModel(bindingResult, model);
		
		if(fitnessEventService.save(fitnessEvent)) {
			model.addAttribute("info", "Pomyślnie dodano nowe zajęcia.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z dodaniem nowych zajęć.");
		}
		
		return showFitnessEvents(model);
	}
	
	@GetMapping("/edit")
	public String showFormToEditFitnessEvent(@RequestParam("eventId") int id, Model model) {
		
		Map<Integer, String> workouts=workoutService.getAllTypesOfWorkoutMappedById();
		Map<Integer, String> trainers=trainerService.getAllTrainersMappedById();
		Map<Integer, String> places=placeService.getAllPlacesMappedById();
		FitnessEvent tempFitnessEvent=fitnessEventService.getById(id);
		
		model.addAttribute("workouts", workouts);
		model.addAttribute("trainers", trainers);
		model.addAttribute("places", places);
		model.addAttribute("fitnessEvent", tempFitnessEvent);
		
		return "fitness-event/edit";
	}
	
	@PostMapping("/edit")
	public String saveFormToEditFitnessEvent(@Valid @ModelAttribute("fitnessEvent") FitnessEvent fitnessEvent,BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) addErrorsToModel(bindingResult, model);
		
		if(fitnessEventService.update(fitnessEvent)) {
			model.addAttribute("info", "Pomyślnie zaktualizowano zajęcia.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z aktualizacją zajęć.");
		}
		
		model.addAttribute("fitnessEvent",fitnessEvent);
		
		return showFitnessEvents(model);
	}
	
	@GetMapping("/delete")
	public String deleteFitnessEvent(@RequestParam("eventId") int id, Model model) {
		
		if(fitnessEventService.delete(id)) {
			model.addAttribute("info", "Zajęcia zostały usunięte.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z usunięciem zajęć.");
		}
		
		return showFitnessEvents(model);
	}
	
	private void addErrorsToModel(BindingResult bindingResult, Model model) {
		
		List<FieldError> fieldErrors=bindingResult.getFieldErrors();
		
		List<String> errors=fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
		
		model.addAttribute("warning", errors);
	}
}
