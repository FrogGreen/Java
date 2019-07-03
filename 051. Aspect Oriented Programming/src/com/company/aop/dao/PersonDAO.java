package com.company.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

	public boolean addPerson() {
		System.out.println(getClass() + ": Simulation of another layer. This time add new person.");
		return false;
	}

	public void earnMoney() {
		System.out.println(getClass() + ": I'm going to work now, to get the money...");
	}
}