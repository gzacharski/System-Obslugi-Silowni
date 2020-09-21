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

import com.myprojects.gza.myGymApp.entity.Equipment;
import com.myprojects.gza.myGymApp.errors.ThereIsNoSuchAnEquipmentException;
import com.myprojects.gza.myGymApp.service.EquipmentService;

@Controller
@RequestMapping("/user/equipments")
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipmentService;
	
	@GetMapping("/")
	public String showEquipment(Model model) {
		
		List<Equipment> equipments=equipmentService.getAll();
		
		if(equipments.size()==0) {
			model.addAttribute("info", "Brak dodanego sprzętu.");
		}
		
		model.addAttribute("equipments", equipments);
		
		return "equipment/list";
	}
	
	@GetMapping("/add")
	public String showFormToAddEquipment(Model model) {
		
		model.addAttribute("equipment", new Equipment());
		
		return "equipment/add";
	}
	
	@PostMapping("/add")
	public String saveFormToAddEquipment(@Valid @ModelAttribute("equipment") Equipment equipment, BindingResult bindingResult, Model model) {
		
		try {
			equipmentService.save(equipment);
			model.addAttribute("info", "Pomyślnie dodano nowy sprzęt.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("warning", "Wystąpił problem z dodaniem nowego sprzętu.");
		}

		return showEquipment(model);
	}
	
	@GetMapping("/edit")
	public String showFormToEditEquipment(@RequestParam("equipmentId") int id, Model model) {
		
		Equipment equipment=equipmentService.getById(id);
		
		model.addAttribute("equipment", equipment);
		
		return "equipment/edit";
	}
	
	@PostMapping("/edit")
	public String saveFormToEditEquipment(@Valid @ModelAttribute("equipment") Equipment equipment, BindingResult bindingResult, Model model) {
		
		try {
			equipmentService.update(equipment);
			model.addAttribute("info", "Pomyślnie zaktualizowano sprzęt.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("warning", "Wystąpił problem z aktualizacją sprzętu.");
		}
		
		return "equipment/edit";
	}
	
	@GetMapping("/search")
	public String searchEquipment(@RequestParam("searchedPhrase") String searchedPhrase, Model model) {
		
		List<Equipment> searchedEquipments=equipmentService.search(searchedPhrase);
		
		model.addAttribute("equipments", searchedEquipments);
		
		if(searchedEquipments.size()==0) {
			model.addAttribute("warning", "Nie znaleziono podanej frazy :(");
		}else {
			model.addAttribute("info", "Znaleziono " +searchedEquipments.size() + " pasujących rezultatów");
		}
		
		return "equipment/list";
	}
	
	@GetMapping("/delete")
	public String deleteEditEquipment(@RequestParam("equipmentId") int id, Model model) {
		
		try {
			equipmentService.delete(id);
			model.addAttribute("info", "Sprzęt został usunięty.");
		} catch (ThereIsNoSuchAnEquipmentException e) {
			e.printStackTrace();
			model.addAttribute("warning", "Wystąpił problem z usunięciem sprzętu.");
		}
		
		return showEquipment(model);
	}
}
