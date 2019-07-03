package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.PersonDAO;
import com.company.entity.Person;

@Service
public class PersonServiceHibernateImpl implements PersonService {

	private PersonDAO personDAO;

	@Autowired
	public PersonServiceHibernateImpl(@Qualifier("personDAOHibernateImpl") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

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