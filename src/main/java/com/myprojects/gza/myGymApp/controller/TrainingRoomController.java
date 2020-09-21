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

import com.myprojects.gza.myGymApp.entity.Place;
import com.myprojects.gza.myGymApp.service.PlaceService;

@Controller
@RequestMapping("/user/trainingRooms")
public class TrainingRoomController {
	
	@Autowired
	private PlaceService placeService;
	
	@GetMapping("/")
	public String showTrainingRooms(Model model) {
		
		List<Place> places=placeService.getPlaces();
		
		model.addAttribute("places", places);
		
		return "training-room/list";
	}
	
	@GetMapping("/add")
	public String showFormToAddTrainingRoom(Model model) {
		
		model.addAttribute("place", new Place());
		
		return "training-room/add";
	}
	
	@PostMapping("/add")
	public String saveFormToAddTrainingRoom(@ModelAttribute("place") Place place, Model model) {
		
		if(placeService.addPlace(place)) {
			model.addAttribute("info", "Pomyślnie dodano nową salę treningową.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z dodaniem nowej sali treningowej do bazy.");
		}
		
		return showTrainingRooms(model);
	}
	
	@GetMapping("/edit")
	public String showFormToEditTrainingRoom(@RequestParam("trainingRoomId") int trainingRoomId, Model model) {
		
		Place tempPlace=placeService.getById(trainingRoomId);
		
		model.addAttribute("place", tempPlace);
		
		return "training-room/edit";
	}
	
	@PostMapping("/edit")
	public String saveFormToEditTrainingRoom(@ModelAttribute("place") Place place, Model model) {
		
		if(placeService.editPlace(place)) {
			model.addAttribute("info", "Pomyślnie zaktualizowano salę treningową.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z aktualizacją sali treningowej.");
		}
		
		return "training-room/edit";
	}
	
	@GetMapping("/delete")
	public String deleteTrainingRoom(@RequestParam("trainingRoomId") int trainingRoomId, Model model) {
		
		if(placeService.deletePlace(trainingRoomId)) {
			model.addAttribute("info", "Sala treningowa została usunięta");
		}else {
			model.addAttribute("warning", "Wystąpił problem z usunięciem sali treningowej.");
		}
		
		return showTrainingRooms(model);
	}
}
