package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.PersonDataJpaRepository;
import com.company.entity.Person;
import com.company.rest.PersonNotFoundException;

@Service
public class PersonServiceDataJpaImpl implements PersonService {

	private PersonDataJpaRepository personDataJpaRepository;

	@Autowired
	public PersonServiceDataJpaImpl(PersonDataJpaRepository personDataJpaRepository) {
		this.personDataJpaRepository = personDataJpaRepository;
	}

	@Override
	@Transactional
	public List<Person> getCharacter() {
		return personDataJpaRepository.findAllByOrderByEmailAsc();
	}

	@Override
	@Transactional
	public void savePerson(Person thisPerson) {
		personDataJpaRepository.save(thisPerson);
	}

	@Override
	@Transactional
	public Person getCharacter(int id) {
		if (personDataJpaRepository.findById(id) == null) {
			throw new PersonNotFoundException("Person id not found - " + id);
		}
		return personDataJpaRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteCharacter(int id) {
		personDataJpaRepository.deleteById(id);
	}
}