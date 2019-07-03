package com.company.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Person;
import com.company.service.PersonService;

@RestController
@RequestMapping("/personRest")
public class PersonRestController {

	@Autowired
	private PersonService personService;

	@GetMapping("/persons")
	public List<Person> getPersons() {
		return personService.getCharacter();
	}

	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable int personId) {
		if (personService.getCharacter(personId) == null) {
			throw new PersonNotFoundException("Person id not found - " + personId);
		}
		return personService.getCharacter(personId);
	}

	@PostMapping("/persons")
	public Person setPerson(@RequestBody Person person) {
		person.setId(0);
		personService.savePerson(person);
		return person;
	}

	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person) {
		personService.savePerson(person);
		return person;
	}

	@DeleteMapping("/persons/{personId}")
	public String deletePerson(@PathVariable int personId) {
		if (personService.getCharacter(personId) == null) {
			throw new PersonNotFoundException("Person id not found - " + personId);
		}
		personService.deleteCharacter(personId);
		return "Deleted person id - " + personId;
	}
}