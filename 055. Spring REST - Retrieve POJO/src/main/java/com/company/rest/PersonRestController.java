package com.company.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Person;

@RestController
@RequestMapping("/personRest")
public class PersonRestController {
	private List<Person> persons;

	@PostConstruct
	public void loadPerson() {
		persons = new ArrayList<>();
		persons.add(new Person("Steven L.", "Walker"));
		persons.add(new Person("Marilyn D.", "Gannon"));
		persons.add(new Person("Eric C.", "Hendrix"));
		persons.add(new Person("Cody C.", "Turner"));
		persons.add(new Person("Lee R.", "Chien"));
	}

	@GetMapping("/persons")
	public List<Person> getPersons() {
		return persons;
	}

	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable int personId) {
		if ((personId >= persons.size()) || (personId < 0)) {
			throw new PersonNotFoundException("Person id not found - " + personId);
		}
		return persons.get(personId);
	}
}