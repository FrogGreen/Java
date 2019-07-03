package com.company.aop.dao;

import org.springframework.stereotype.Component;

import com.company.aop.Account;

@Component
public class AccountDAO {

	private String name;
	private String securityLevel;

	public void addAccount() {
		System.out.println(getClass() + ": Simulation of another layer. This time create new account.");
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + ": Simulation of another layer. This time add new account.");
	}

	public boolean moneyCalc() {
		System.out.println(getClass() + ": moneyCalc()");
		return true;
	}

	public String getName() {
		System.out.println("Name is: " + this.name);
		return name;
	}

	public String getName(int a) {
		if (a == 0) {
			throw new RuntimeException("Something went wrong!");
		}
		System.out.println("Name is: " + this.name);
		return name;
	}

	public String getName(int a, int b) {
		try {
			if (a == 0) {
				throw new RuntimeException("Something went wrong!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Name is: " + this.name);
		return name;
	}

	public void setName(String name) {
		System.out.println("Name is: " + this.name);
		this.name = name;
	}

	public String getSecurityLevel() {
		System.out.println("Security level is: " + this.securityLevel);
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		System.out.println("Security level is: " + this.securityLevel);
		this.securityLevel = securityLevel;
	}
}