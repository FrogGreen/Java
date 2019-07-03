package com.company.service;

import java.util.List;

import com.company.entity.Person;

public interface PersonService {

	public List<Person> getCharacter();

	public void savePerson(Person thisPerson);

	public Person getCharacter(int id);

	public void deleteCharacter(int id);
}