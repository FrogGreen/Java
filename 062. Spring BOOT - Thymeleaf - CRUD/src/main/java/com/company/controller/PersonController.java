package com.company.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.entity.Person;
import com.company.service.PersonService;

@Controller
@RequestMapping("/springbootthymeleaf")
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/listold")
	public String listPersonOld(Model model) {
		List<Person> persons = personService.getCharacter();
		model.addAttribute("persons", persons);
		return "personsold";
	}

	@GetMapping("/listnew")
	public String listPersonNew(Model model) {
		List<Person> persons = personService.getCharacter();
		model.addAttribute("persons", persons);
		return "personsNew";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "personForm";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int id, Model model) {
		Person person = personService.getCharacter(id);
		model.addAttribute("person", person);
		return "personForm";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/springbootthymeleaf/listnew";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("personId") int id) {
		personService.deleteCharacter(id);
		return "redirect:/springbootthymeleaf/listnew";
	}
}