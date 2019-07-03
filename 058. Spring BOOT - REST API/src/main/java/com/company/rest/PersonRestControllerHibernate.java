package com.company.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Person;
import com.company.dao.PersonDAO;

@RestController
@RequestMapping("/springboothibernaterestapi")
public class PersonRestControllerHibernate {

	private PersonDAO personDAO;

	@Autowired
	public PersonRestControllerHibernate(@Qualifier("personDAOHibernateImpl") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@GetMapping("/persons")
	public List<Person> getPersons() {
		return personDAO.getCharacter();
	}

	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable int personId) {
		if (personDAO.getCharacter(personId) == null) {
			throw new PersonNotFoundException("Person id not found - " + personId);
		}
		return personDAO.getCharacter(personId);
	}

	@PostMapping("/persons")
	public Person setPerson(@RequestBody Person person) {
		person.setId(0);
		personDAO.savePerson(person);
		return person;
	}

	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person) {
		personDAO.savePerson(person);
		return person;
	}

	@DeleteMapping("/persons/{personId}")
	public String deletePerson(@PathVariable int personId) {
		if (personDAO.getCharacter(personId) == null) {
			throw new PersonNotFoundException("Person id not found - " + personId);
		}
		personDAO.deleteCharacter(personId);
		return "Deleted person id - " + personId;
	}
}