package com.company.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class SetAspect {

	@Before("com.company.aop.aspect.LoggingFormula.setterDaoMethod()")
	public void beforeSetAdvice() {
		System.out.println("\n-----=====>> Executing set method <<=====-----\n-----=====>> @Before <<=====-----");
	}
	
	@After("com.company.aop.aspect.LoggingFormula.setterDaoMethod()")
	public void afterSetAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n-----=====>> Executing set method <<=====-----\n-----=====>> @After <<=====-----");
		Object[] objects = theJoinPoint.getArgs();
		System.out.print("Returned value is: ");
		for (Object object : objects) {
			System.out.println(object);
		}
	}
}