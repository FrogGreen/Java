package com.company.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class LoggingFormula {

//	// @Before("execution(public boolean com.company.aop.dao.PersonDAO.addPerson())")
//	// @Before("execution(public void addAccount())")
//	// @Before("execution(* add*())")
//	@Before("execution(* com.company.aop.dao.*.*(..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("-----=====>> Executing @Before called method <<=====-----");
//	}

	// create pointcut for package
	@Pointcut("execution(* com.company.aop.dao.*.*(..))")
	private void packagePath() {
	}

	// create pointcut for getter methods
	@Pointcut("execution(* com.company.aop.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut for setter methods
	@Pointcut("execution(* com.company.aop.dao.*.set*(..))")
	private void setter() {
	}

	// create pointcut for include package and no getter or setter
	@Pointcut("packagePath() && !(getter() || setter())")
	public void otherDaoMethod() {
	}

	// create pointcut for include package and getter
	@Pointcut("packagePath() && getter()")
	public void getterDaoMethod() {
	}

	// create pointcut for include package and setter
	@Pointcut("packagePath() && setter()")
	public void setterDaoMethod() {
	}
}