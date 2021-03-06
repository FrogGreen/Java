package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.PersonDAO;
import com.company.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public List<Person> getCharacter() {
		return personDAO.getCharacter();
	}

	@Override
	@Transactional
	public void savePerson(Person thisPerson) {
		personDAO.savePerson(thisPerson);
	}

	@Override
	@Transactional
	public Person getCharacter(int id) {
		return personDAO.getCharacter(id);
	}

	@Override
	@Transactional
	public void deleteCharacter(int id) {
		personDAO.deleteCharacter(id);
	}
}