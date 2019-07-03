package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.model.Person;

@Controller
@RequestMapping("/springbootthymeleaf")
public class PersonController {

	private List<Person> persons;

	@PostConstruct
	private void loadData() {
		Person person1 = new Person(1,"Lucas","Zimmerman","lucas.zimmerman@gmail.com");
		Person person2 = new Person(2,"Dominik","Theiss","dominik.theiss@gmail.com");
		Person person3 = new Person(3,"Eric","Huber","eric.huber@gmail.com");
		Person person4 = new Person(4,"Manuela","Bosch","manuela.bosch@gmail.com");
		Person person5 = new Person(5,"Barbara","Fink","barbara.fink@gmail.com");
		Person person6 = new Person(6,"Klaudia","Fiedler","klaudia.fiedler@gmail.com");
		
		persons = new ArrayList<>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		persons.add(person5);
		persons.add(person6);
	}

	@GetMapping("/listold")
	public String listPersonOld(Model model) {
		model.addAttribute("persons", persons);
		return "personsold";
	}

	@GetMapping("/listnew")
	public String listPersonNew(Model model) {
		model.addAttribute("persons", persons);
		return "personsNew";
	}
}