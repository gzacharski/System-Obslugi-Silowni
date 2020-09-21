package com.myprojects.gza.myGymApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myprojects.gza.myGymApp.entity.Workout;
import com.myprojects.gza.myGymApp.service.WorkoutService;

@Controller
@RequestMapping("/user/workouts")
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/")
	public String showWorkouts(Model model) {
		
		List<Workout> workouts=workoutService.getWorkouts();
		
		model.addAttribute("workouts", workouts);
		
		return "workout/list";
	}
	
	@GetMapping("/add")
	public String showFormToAddWorkout(Model model) {
		
		model.addAttribute("workout", new Workout());
		
		return "workout/add";
	}
	
	@PostMapping("/add")
	public String saveFormToAddWorkout(@Valid @ModelAttribute("workout") Workout workout, BindingResult bindingResult, Model model ) {
		
		if(bindingResult.hasErrors()) return "workout/add";
		
		if(workoutService.addWorkout(workout)) {
			model.addAttribute("info", "Pomyślnie dodano nowy typ zajęć.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z dodaniem nowych zajęć do bazy.");
		}
		
		return showWorkouts(model);
	}
	
	@GetMapping("/edit")
	public String showFormToEditWorkout(@RequestParam("workoutId") int workoutId, Model model) {
		
		Workout tempWorkout=workoutService.getWorkoutById(workoutId);
		
		model.addAttribute("workout", tempWorkout);
		
		return "workout/edit";
	}
	
	@PostMapping("/edit")
	public String saveFormToEditWorkout(@Valid @ModelAttribute("workout") Workout workout, BindingResult bindingResult,  Model model) {
		
		if(bindingResult.hasErrors()) return "workout/edit";
		
		if(workoutService.updateWorkout(workout)) {
			model.addAttribute("info", "Pomyślnie zaktualizowano typ zajęć.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z aktualizacją zajęć.");
		}
		
		return "workout/edit";
	}
	
	@GetMapping("/delete")
	public String deleteWorkout(@RequestParam("workoutId") int workoutId, Model model) {
		
		try {
			workoutService.deleteWorkout(workoutId);
			model.addAttribute("info", "Typ zajęć został usunięty");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("warning", "Wystąpił problem z usunięciem danego typu danych.");
		}
	
		return showWorkouts(model);
	}
	
	@GetMapping("/search")
	public String searchWorkout(@RequestParam("searchedPhrase") String searchedPhrase, Model model) {
		
		List<Workout> searchedWorkouts=workoutService.searchWorkout(searchedPhrase);
		
		model.addAttribute("workouts", searchedWorkouts);
		
		if(searchedWorkouts.size()==0) {
			model.addAttribute("warning", "Nie znaleziono podanej frazy :(");
		}else {
			model.addAttribute("info", "Znaleziono " +searchedWorkouts.size() + " pasujących rezultatów");
		}
		
		return "workout/list";
	}
}
