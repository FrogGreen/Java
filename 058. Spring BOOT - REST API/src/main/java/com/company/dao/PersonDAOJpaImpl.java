package com.company.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.entity.Person;

@Repository
public class PersonDAOJpaImpl implements PersonDAO {

	private EntityManager entityManager;

	@Autowired
	public PersonDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Person> getCharacter() {
		Query query = entityManager.createQuery("from Person", Person.class);
		List<Person> persons = query.getResultList();
		return persons;
	}

	@Override
	public void savePerson(Person thisPerson) {
		Person thePerson = entityManager.merge(thisPerson);
		thisPerson.setId(thePerson.getId());
	}

	@Override
	public Person getCharacter(int id) {
		Person thePerson = entityManager.find(Person.class, id);
		return thePerson;
	}

	@Override
	public void deleteCharacter(int id) {
		Query query = entityManager.createQuery("delete from Person where id=:personId");
		query.setParameter("personId", id);
		query.executeUpdate();
	}
}