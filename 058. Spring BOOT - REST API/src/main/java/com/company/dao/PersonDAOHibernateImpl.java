package com.company.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.entity.Person;

@Repository
public class PersonDAOHibernateImpl implements PersonDAO {

	private EntityManager entityManager;

	@Autowired
	public PersonDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Person> getCharacter() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Person> query = currentSession.createQuery("from Person", Person.class);
		List<Person> persons = query.getResultList();
		return persons;
	}

	@Override
	public void savePerson(Person thisPerson) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(thisPerson);
	}

	@Override
	public Person getCharacter(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Person thePerson = currentSession.get(Person.class, id);
		return thePerson;
	}

	@Override
	public void deleteCharacter(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Person> query = currentSession.createQuery("delete from Person where id=:personId");
		query.setParameter("personId", id);
		query.executeUpdate();
	}
}