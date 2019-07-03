package com.company.onetomany.unidirectional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// Check database connection
		System.out.println("Check database connection:");
		checkDatabaseConnection();

		// Create database object
		System.out.println("Create database object:");
		createDatabaseObject();

		// Read database object
		System.out.println("Read database object:");
		readDatabaseObject();

		// Delete database object
		System.out.println("Delete database object:");
		deleteDatabaseObject();
	}

	public static void checkDatabaseConnection() {
		String jdbcURL = "jdbc:mysql://localhost:3306/FrogGreenO2M?useSSL=false&serverTimezone=UTC";
		String user = "FrogGreen";
		String password = "FrogGreen";

		try {
			System.out.println("Connection in progress...");
			Connection connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println("Connection succesfull");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}

	public static void createDatabaseObject() {
		// Create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfgO2M.xml")
				.addAnnotatedClass(Person.class).addAnnotatedClass(PersonDetail.class).addAnnotatedClass(Car.class).addAnnotatedClass(Rating.class)
				.buildSessionFactory();

		// Create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// Create object
			System.out.println("Creation object...");
			Person personOne = new Person("Paul", "Walker", "Paul.Walker@company.com");
			PersonDetail personDetailOne = new PersonDetail("Grenn 42, London", "Music");
			personOne.setPersonDetail(personDetailOne);
			Car carOneOne = new Car("Hyundai I30");
			Car carOneTwo = new Car("Hyundai I40");
			Car carOneThree = new Car("Opel Corsa E");
			personOne.addCar(carOneOne);
			personOne.addCar(carOneTwo);
			personOne.addCar(carOneThree);
			carOneOne.addRating(new Rating(4));
			carOneTwo.addRating(new Rating(5));
			carOneOne.addRating(new Rating(6));
			carOneTwo.addRating(new Rating(4));
			carOneOne.addRating(new Rating(4));
			carOneOne.addRating(new Rating(3));
			carOneTwo.addRating(new Rating(6));
			carOneTwo.addRating(new Rating(4));
			carOneTwo.addRating(new Rating(4));
			carOneOne.addRating(new Rating(5));
			carOneTwo.addRating(new Rating(6));
			carOneTwo.addRating(new Rating(4));
			
			
			
			Person personTwo = new Person("Tom", "Elton", "Tom.Elton@company.com");
			PersonDetail personDetailTwo = new PersonDetail("Red 12, London", "Cinema");
			personTwo.setPersonDetail(personDetailTwo);
			Car carTwoOne = new Car("Ford Fiesta");
			Car carTwoTwo = new Car("Ford Focus MK3");
			personTwo.addCar(carTwoOne);
			personTwo.addCar(carTwoTwo);
			
			Person personThree = new Person("John", "Coffee", "John.Coffee@company.com");
			PersonDetail personDetailThree = new PersonDetail("Yellow 22, London", "Football");
			personThree.setPersonDetail(personDetailThree);
			Car carThreeOne = new Car("Fiat Bravo");
			personThree.addCar(carThreeOne);
			
			// Start transaction
			session.beginTransaction();

			// Save object in database
			System.out.println("Save object...");
			session.save(personOne);
			session.save(carOneOne);
			session.save(carOneTwo);
			session.save(carOneThree);
			
			session.save(personTwo);
			session.save(carTwoOne);
			session.save(carTwoTwo);
			
			session.save(personThree);
			session.save(carThreeOne);

			// Commit changes
			session.getTransaction().commit();
			System.out.println("Creation committed");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public static void readDatabaseObject() {
		// Create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfgO2M.xml")
				.addAnnotatedClass(Person.class).addAnnotatedClass(PersonDetail.class).addAnnotatedClass(Car.class).addAnnotatedClass(Rating.class)
				.buildSessionFactory();

		// Create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// Read object
			System.out.println("Reading object...");

			// Start transaction
			session.beginTransaction();

			// Retrieve third object from database
			System.out.println(session.get(Person.class, 3));

			// Retrieve all data about Paul and Elton
			List<Person> listPerson = session
					.createQuery("from Person p where p.lastName = 'Coffee' OR p.firstName LIKE '%ul'").getResultList();
			retrievePerson(listPerson);

			// Retrieve all object from database
			listPerson = session.createQuery("from Person").getResultList();
			retrievePerson(listPerson);

			// Commit changes
			session.getTransaction().commit();
			System.out.println("Changes committed");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public static void deleteDatabaseObject() {
		// Create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfgO2M.xml")
				.addAnnotatedClass(Person.class).addAnnotatedClass(PersonDetail.class).addAnnotatedClass(Car.class).addAnnotatedClass(Rating.class)
				.buildSessionFactory();

		// Create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// Read object
			System.out.println("Delete object...");

			// Start transaction
			session.beginTransaction();

			Car car = session.get(Car.class, 1);
			System.out.println(car);
			System.out.println(car.getRatings());

			session.delete(car);

			// Commit changes
			session.getTransaction().commit();
			System.out.println("Delete committed");

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void retrievePerson(List<Person> listPerson) {
		for (Person person : listPerson) {
			System.out.println(person);
		}
	}
}