package com.company.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.aop.dao.AccountDAO;
import com.company.aop.dao.PersonDAO;

public class Main {

	public static void main(String[] args) {

		System.out.println("Classic annotation: ");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		PersonDAO personDAO = context.getBean("personDAO", PersonDAO.class);

		System.out.println("First attempt:");
		accountDAO.addAccount();

		System.out.println("\nTry it again:");
		Account myAccount = new Account();
		myAccount.setName("foo");
		myAccount.setSecurityLevel("Highest");

		accountDAO.addAccount(myAccount);
		accountDAO.moneyCalc();

		String name = myAccount.getName();
		String securityLevel = myAccount.getSecurityLevel();

		accountDAO.setName("fooTwo");
		accountDAO.getName();

		try {
			accountDAO.getName(0);
		} catch (Exception exception) {
		}

		System.out.println("\nAnother way:");
		personDAO.addPerson();
		personDAO.earnMoney();

		System.out.println("Around annotation: ");
		Logger logger = Logger.getLogger(Main.class.getName());
		logger.info("Main class");
		logger.info("Calling getName()");
		name = accountDAO.getName(0,0);
		logger.info("\nChosen name is: " + name);
		logger.info("Complited");
		context.close();
	}
}