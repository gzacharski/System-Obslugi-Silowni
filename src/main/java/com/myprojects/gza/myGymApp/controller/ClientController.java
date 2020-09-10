package com.myprojects.gza.myGymApp.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myprojects.gza.myGymApp.entity.FitnessEvent;
import com.myprojects.gza.myGymApp.entity.Role;
import com.myprojects.gza.myGymApp.entity.User;
import com.myprojects.gza.myGymApp.errors.ChronologicalSigingUpToFitnessEventException;
import com.myprojects.gza.myGymApp.errors.MaxNumberOfPeopleInTheFitnessEventException;
import com.myprojects.gza.myGymApp.errors.NoSuchAUserOnFitnessEventListException;
import com.myprojects.gza.myGymApp.errors.RemovalOfUserFromFitnessEventException;
import com.myprojects.gza.myGymApp.errors.SigningUpToFitnessEventException;
import com.myprojects.gza.myGymApp.errors.TooEarlyException;
import com.myprojects.gza.myGymApp.errors.TooLateException;
import com.myprojects.gza.myGymApp.errors.UserAlreadyParticipatesInTheFitnessEventException;
import com.myprojects.gza.myGymApp.errors.UserCanNotCancelParticipationFromPastFitnessEventsException;
import com.myprojects.gza.myGymApp.errors.UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts;
import com.myprojects.gza.myGymApp.service.FitnessEventService;
import com.myprojects.gza.myGymApp.service.UserService;

@Controller
@RequestMapping("/user/client")
public class ClientController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FitnessEventService fitnessEventService;
	
	@GetMapping("/main")
	public String showMainPage() {
		return "client/main-page";
	}
	
	@GetMapping("/editUser")
	public String showFormToEditUserData(Model model, Authentication authentication) {
		
		User theUser = getUser(authentication);
		
		model.addAttribute("user", theUser);
		
		return "client/manage-account";
	}

	@PostMapping("/editUser")
	public String saveFormToEditUserData(@Valid @ModelAttribute("user") User user, Model model) {
		
		Collection<Role> roles=userService.getById(user.getId()).getRoles();
		
		user.setRoles(roles);
		
		if(userService.update(user)) {
			model.addAttribute("success", "Twoje dane zostały zaktualizowane.");
		}else {
			model.addAttribute("danger", "Wystąpił problem z aktualizacją danych.");
			
		}
		
		return "client/manage-account";
	}
	
	@GetMapping("/events")
	public String showWorkoutsInCurrentWeek(Model model, Authentication authentication) {
		
		User theUser = getUser(authentication);
		
		LocalDate localDate=LocalDate.now();
		
		addToModelUserFitnessEventsInSelectedWeek(model, theUser, localDate);
		
		return "client/user-events";
	}
	
	@PostMapping("/events/nextWeek")
	public String showWorkoutsInNextWeek(@ModelAttribute("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate,
			Model model, Authentication authentication) {
		
		User theUser = getUser(authentication);
		
		localDate=localDate.plusDays(7);
		
		addToModelUserFitnessEventsInSelectedWeek(model, theUser, localDate);
		
		return "client/user-events";
	}
	
	@PostMapping("/events/previousWeek")
	public String showWorkoutsInPreviousWeek(@ModelAttribute("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate,
			Model model, Authentication authentication) {
		
		User theUser = getUser(authentication);
		
		localDate=localDate.minusDays(7);
		
		addToModelUserFitnessEventsInSelectedWeek(model, theUser, localDate);
		
		return "client/user-events";
	}
	
	private void addToModelUserFitnessEventsInSelectedWeek(Model model, User theUser, LocalDate localDate) {
		List<FitnessEvent> userEvents=fitnessEventService.getUserEventsInCurrentWeek(theUser, localDate);
		
		model.addAttribute("fitnessEvents", userEvents);
		
		setDateParameters(model, localDate);
	}
	
	private void setDateParameters(Model model, LocalDate localDate) {
		model.addAttribute("selectedDate",localDate);
		model.addAttribute("mondayOfCurrentWeek",localDate.minusDays(localDate.getDayOfWeek().getValue()-1));
		model.addAttribute("sundayOfCurrentWeek", localDate.plusDays(7-localDate.getDayOfWeek().getValue()));
		model.addAttribute("localDateTimeFormat", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
	}
	
	@GetMapping("/joinEvent")
	public ModelAndView joinEvent(@RequestParam("fitnessEventId") int fitnessEventId, ModelMap model, Authentication authentication) {
		
		User theUser = getUser(authentication);
		
		try {
			
			fitnessEventService.addNewParticipantToFitnessEvent(theUser, fitnessEventId);
			model.addAttribute("success", "Pomyślnie zapisano na nowe zajęcia");
			
		} catch (SigningUpToFitnessEventException exception) {
			
			if(exception instanceof MaxNumberOfPeopleInTheFitnessEventException) {
				
				model.addAttribute("warning", "Niestety liczba miejsc na wybrane zajęcia jest już pełna. Kliknij ");
				
			}else if(exception instanceof UserAlreadyParticipatesInTheFitnessEventException) {
				
				model.addAttribute("warning", "Nie można zapisać się dwa razy na te same zajęcia.");
				
			}else if(exception instanceof ChronologicalSigingUpToFitnessEventException) {
				
				if(exception.getCause() instanceof TooEarlyException) {
					model.addAttribute("warning", "Zapisy na wskazane zajęcia rozpoczynają się na 7 dni przed datą wydarzenia zajęć.");
				}else if(exception.getCause() instanceof TooLateException) {
					model.addAttribute("warning", "Nie można się zapisać na zajęcia, które już się odbyły.");
				}else {
					model.addAttribute("danger", "Ups! Wystąpił błąd podczas zapisu na zajęcia. Spróbuj jeszcze raz.");
				}
			}else {
				model.addAttribute("danger", "Ups! Wystąpił błąd podczas zapisu na zajęcia. Spróbuj jeszcze raz.");
			}
		}

		return new ModelAndView("forward:/fitnessEvents", model);
	}
	
	@GetMapping("/cancelEvent")
	public ModelAndView cancelEvent(@RequestParam("fitnessEventId") int fitnessEventId, ModelMap model, Authentication authentication) {
		
		User theUser = getUser(authentication);
		
		try {
			
			fitnessEventService.removeParticipantFromFitnessEvent(theUser, fitnessEventId);
			model.addAttribute("success", "Pomyślnie anulowano udział w zajęciach");
			
		} catch (RemovalOfUserFromFitnessEventException exception) {
			
			if(exception instanceof NoSuchAUserOnFitnessEventListException) {
				model.addAttribute("warning", "Nie ma wskazanego użytkownika na liście danego wydarzenia.");
			}else if(exception instanceof UserIsNotAllowedToCancelPartcipationOneHourBeforeTheEventStarts) {
				model.addAttribute("warning", "Nie możesz anulować udziału na mniej niż godzinę przed rozpoczęciem zajęć.");
			}else if(exception instanceof UserCanNotCancelParticipationFromPastFitnessEventsException) {
				model.addAttribute("danger", "Nie można anulować udziału w wydarzeniu, które już się odbyło.");
			}else {
				model.addAttribute("danger", "Ups! Wystąpił błąd podczas anulowania udziału w zajęciach. Spróbuj jeszcze raz.");
			}
		}
			
		return new ModelAndView("forward:/fitnessEvents", model);
	}
	
	private User getUser(Authentication authentication) {
		String userEmail=authentication.getName();
		
		int userId=userService.findByEmail(userEmail).getId();
		
		User theUser=userService.getAllUserInfoById(userId);
		return theUser;
	}

}
