package com.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Person> getCharacter() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Person> query = currentSession.createQuery("from Person order by lastName", Person.class);
		List<Person> persons = query.getResultList();
		return persons;
	}

	@Override
	public void savePerson(Person thisPerson) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thisPerson);
	}

	@Override
	public Person getCharacter(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Person thePerson = currentSession.get(Person.class, id);
		return thePerson;
	}

	@Override
	public void deleteCharacter(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Person where id=:personId");
		query.setParameter("personId", id);
		query.executeUpdate();
	}
}