package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.dao.PersonDAO;
import com.company.entity.Person;
import com.company.service.PersonService;

@Controller
@RequestMapping("/character")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/list")
	public String listCharacter(Model theModel) {
		List<Person> thePersons = personService.getCharacter();
		theModel.addAttribute("persons", thePersons);
		return "person-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Person thisPerson = new Person();
		theModel.addAttribute("person", thisPerson);
		return "person-form";
	}

	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute("person") Person thisPerson) {
		personService.savePerson(thisPerson);
		return "redirect:/character/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int id, Model theModel) {
		Person thePerson = personService.getCharacter(id);
		theModel.addAttribute("person", thePerson);
		return "person-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("personId") int id) {
		personService.deleteCharacter(id);
		return "redirect:/character/list";
	}
}