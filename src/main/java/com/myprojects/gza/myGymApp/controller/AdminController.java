package com.myprojects.gza.myGymApp.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myprojects.gza.myGymApp.entity.FitnessEvent;
import com.myprojects.gza.myGymApp.entity.Place;
import com.myprojects.gza.myGymApp.entity.Trainer;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.entity.Workout;
import com.myprojects.gza.myGymApp.service.FitnessEventService;
import com.myprojects.gza.myGymApp.service.PlaceService;
import com.myprojects.gza.myGymApp.service.TrainerService;
import com.myprojects.gza.myGymApp.service.UserService;
import com.myprojects.gza.myGymApp.service.WorkoutService;

@Controller
@RequestMapping("/user/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private FitnessEventService fitnessEventService;
	
	@GetMapping("/main")
	public String showMainPage() {
		return "admin/main-page";
	}
	
	@GetMapping("/users")
	public String showUsers(Model model) {
		
		List<User> users=userService.getAllUsers();
		
		model.addAttribute("users", users);
		
		return "admin/user-list";
	}
	
	@GetMapping("/users/search")
	public String searchUser(@RequestParam("searchedPhrase") String searchedPhrase, Model model) {
		
		List<User> users=userService.search(searchedPhrase);
		
		model.addAttribute("users", users);
		
		if(users.size()==0) {
			model.addAttribute("warning", "Nie znaleziono podanej frazy :(");
		}else {
			model.addAttribute("info", "Znaleziono " +users.size() + " pasujących rezultatów");
		}
		
		return "admin/user-list";
	}
	
	@GetMapping("/editUser")
	public String showFormToEditUser(@RequestParam("userId") int userId, Model model) {
		
		User theUser=userService.getAllUserInfoById(userId);
		
		theUser.mapRoleCollectionToArray();
		
		model.addAttribute("user", theUser);
		
		return "admin/user-edit";
	}
	
	@PostMapping("/editUser")
	public String saveFormToEditUser(@ModelAttribute("user") User theUser, Model theModel) {
		
		theUser.mapArrayToRoleCollection();
	
		userService.update(theUser);
		
		theModel.addAttribute("hasBeenSaved", true);
		
		return "admin/user-edit";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId, Model model) {
		
		String userHasbeenRemoved="Użytkownik został pomyślnie usunięty";
			
		if(userService.delete(userId)) {
			userHasbeenRemoved="Użytkownik został pomyślnie usunięty";
		}else {
			userHasbeenRemoved="Ups! Wystąpił problem";
		}
		
		model.addAttribute("info", userHasbeenRemoved);
		
		return showUsers(model);
	}
	
	@GetMapping("/trainers")
	public String showTrainers(Model model) {
		
		List<Trainer> trainers=trainerService.getTrainers();
		
		model.addAttribute("trainers", trainers);
		
		return "admin/trainer-list";
	}
	
	@GetMapping("/trainers/add")
	public String showFormToAddTrainer(Model model) {
		
		Map<Integer, String> candidates=
				userService.getUserWithTrainerRole().stream()
				.collect(Collectors.toMap(User::getId, user -> user.getName().concat(" ").concat(user.getSurname())));
		
		model.addAttribute("newTrainer", new Trainer());
		model.addAttribute("trainersToBe", candidates);
		
		return "admin/trainer-add";
	}
	
	@PostMapping("/trainers/add")
	public String saveFormToAddTrainer(@ModelAttribute("newTrainer") Trainer trainer, Model model) {
		
		System.out.println(trainer.toString());
		
		if(trainerService.addNewTrainer(trainer)) {
			model.addAttribute("info", "Pomyślnie dodano nowego trenera.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z dodaniem użytkownika do bazy.");
		}

		return showTrainers(model);
	}
	
	@GetMapping("/trainers/delete")
	public String deleteTrainer(@RequestParam("trainerId") int trainerId, Model model) {
		
		try {
			trainerService.deleteTrainer(trainerId);
			model.addAttribute("info", "Trener został usunięty");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("warning", "Wystąpił problem z aktualizacją danych trenera.");
		}
	
		return showTrainers(model);
	}
	
	@GetMapping("/trainers/edit")
	public String showFormToEditTrainer(@RequestParam("trainerId") int trainerId, Model model) {
		
		Trainer trainerToEdit=trainerService.getTrainer(trainerId);
		
		model.addAttribute("trainer", trainerToEdit);
		
		return "admin/trainer-edit";
	}
	
	@PostMapping("/trainers/edit")
	public String saveFormToEditTrainer(@ModelAttribute("trainer") Trainer trainer, Model model) {
		
		System.out.println(trainer.toString());
		
		if(trainerService.addNewTrainer(trainer)) {
			model.addAttribute("info", "Pomyślnie zaktualizowano dane trenera.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z aktualizacją danych trenera.");
		}
		
		return "admin/trainer-edit";
	}
	
	@GetMapping("/trainers/search")
	public String searchTrainer(@RequestParam("searchedPhrase") String searchedPhrase, Model model) {

		List<Trainer> searchedTrainers=trainerService.searchTrainer(searchedPhrase);
		
		model.addAttribute("trainers", searchedTrainers);
		
		if(searchedTrainers.size()==0) {
			model.addAttribute("warning", "Nie znaleziono podanej frazy :(");
		}else {
			model.addAttribute("info", "Znaleziono " +searchedTrainers.size() + " pasujących rezultatów");
		}
		
		return "admin/trainer-list";
	}
	
	@GetMapping("/workouts")
	public String showWorkouts(Model model) {
		
		List<Workout> workouts=workoutService.getWorkouts();
		
		model.addAttribute("workouts", workouts);
		
		return "admin/workout-list";
	}
	
	@GetMapping("/workouts/add")
	public String showFormToAddWorkout(Model model) {
		
		model.addAttribute("workout", new Workout());
		
		return "admin/workout-add";
	}
	
	@PostMapping("/workouts/add")
	public String saveFormToAddWorkout(@ModelAttribute("workout") Workout workout, Model model) {
		
		if(workoutService.addWorkout(workout)) {
			model.addAttribute("info", "Pomyślnie dodano nowy typ zajęć.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z dodaniem nowych zajęć do bazy.");
		}
		
		return showWorkouts(model);
	}
	
	@GetMapping("/workouts/edit")
	public String showFormToEditWorkout(@RequestParam("workoutId") int workoutId, Model model) {
		
		Workout tempWorkout=workoutService.getWorkoutById(workoutId);
		
		model.addAttribute("workout", tempWorkout);
		
		return "admin/workout-edit";
	}
	
	@PostMapping("/workouts/edit")
	public String saveFormToEditWorkout(@ModelAttribute("workout") Workout workout, Model model) {
		
		if(workoutService.updateWorkout(workout)) {
			model.addAttribute("info", "Pomyślnie zaktualizowano typ zajęć.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z aktualizacją zajęć.");
		}
		
		return "admin/workout-edit";
	}
	
	@GetMapping("/workouts/delete")
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
	
	@GetMapping("/trainingRooms")
	public String showTrainingRooms(Model model) {
		
		List<Place> places=placeService.getPlaces();
		
		model.addAttribute("places", places);
		
		return "admin/training-room-list";
	}
	
	@GetMapping("/trainingRooms/add")
	public String showFormToAddTrainingRoom(Model model) {
		
		model.addAttribute("place", new Place());
		
		return "admin/training-room-add";
	}
	
	@PostMapping("/trainingRooms/add")
	public String saveFormToAddTrainingRoom(@ModelAttribute("place") Place place, Model model) {
		
		if(placeService.addPlace(place)) {
			model.addAttribute("info", "Pomyślnie dodano nową salę treningową.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z dodaniem nowej sali treningowej do bazy.");
		}
		
		return showTrainingRooms(model);
	}
	
	@GetMapping("/trainingRooms/edit")
	public String showFormToEditTrainingRoom(@RequestParam("trainingRoomId") int trainingRoomId, Model model) {
		
		Place tempPlace=placeService.getById(trainingRoomId);
		
		model.addAttribute("place", tempPlace);
		
		return "admin/training-room-add";
	}
	
	@PostMapping("/trainingRooms/edit")
	public String saveFormToEditTrainingRoom(@ModelAttribute("place") Place place, Model model) {
		
		if(placeService.editPlace(place)) {
			model.addAttribute("info", "Pomyślnie zaktualizowano salę treningową.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z aktualizacją sali treningowej.");
		}
		
		return "admin/training-room-add";
	}
	
	@GetMapping("/trainingRooms/delete")
	public String deleteTrainingRoom(@RequestParam("trainingRoomId") int trainingRoomId, Model model) {
		
		if(placeService.deletePlace(trainingRoomId)) {
			model.addAttribute("info", "Sala treningowa została usunięta");
		}else {
			model.addAttribute("warning", "Wystąpił problem z usunięciem sali treningowej.");
		}
		
		return showTrainingRooms(model);
	}
	
	@GetMapping("/events")
	public String showFitnessEvents(Model model) {
		
		List<FitnessEvent> fitnessEvents=fitnessEventService.getAll();
		
		model.addAttribute("events", fitnessEvents);
		model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		
		return "admin/fitness-event-list";
	}
	
	@GetMapping("/events/add")
	public String showFormToAddFitnessEvent(Model model) {
		
		Map<Integer, String> workouts=workoutService.getAllTypesOfWorkoutMappedById();
		Map<Integer, String> trainers=trainerService.getAllTrainersMappedById();
		Map<Integer, String> places=placeService.getAllPlacesMappedById();
		
		model.addAttribute("workouts", workouts);
		model.addAttribute("trainers", trainers);
		model.addAttribute("places", places);
		model.addAttribute("fitnessEvent", new FitnessEvent());

		return "admin/fitness-event-add";
	}
	
	@PostMapping("/events/add")
	public String saveFormToAddFitnessEvent(@ModelAttribute("fitnessEvent") FitnessEvent fitnessEvent, Model model) {
		
		if(fitnessEventService.save(fitnessEvent)) {
			model.addAttribute("info", "Pomyślnie dodano nowe zajęcia.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z dodaniem nowych zajęć.");
		}
		
		return showFitnessEvents(model);
	}
	
	@GetMapping("/events/edit")
	public String showFormToEditFitnessEvent(@RequestParam("eventId") int id, Model model) {
		
		Map<Integer, String> workouts=workoutService.getAllTypesOfWorkoutMappedById();
		Map<Integer, String> trainers=trainerService.getAllTrainersMappedById();
		Map<Integer, String> places=placeService.getAllPlacesMappedById();
		FitnessEvent tempFitnessEvent=fitnessEventService.getById(id);
		
		model.addAttribute("workouts", workouts);
		model.addAttribute("trainers", trainers);
		model.addAttribute("places", places);
		model.addAttribute("fitnessEvent", tempFitnessEvent);
		
		return "admin/fitness-event-edit";
	}
	
	@PostMapping("/events/edit")
	public String saveFormToEditFitnessEvent(@ModelAttribute("fitnessEvent") FitnessEvent fitnessEvent, Model model) {
		
		if(fitnessEventService.update(fitnessEvent)) {
			model.addAttribute("info", "Pomyślnie zaktualizowano zajęcia.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z aktualizacją zajęć.");
		}
		
		model.addAttribute("fitnessEvent",fitnessEvent);
		
		return "admin/fitness-event-edit";
	}
	
	@GetMapping("/events/delete")
	public String deleteFitnessEvent(@RequestParam("eventId") int id, Model model) {
		
		if(fitnessEventService.delete(id)) {
			model.addAttribute("info", "Zajęcia zostały usunięte.");
		}else {
			model.addAttribute("warning", "Wystąpił problem z usunięciem zajęć.");
		}
		
		return showFitnessEvents(model);
	}

}
