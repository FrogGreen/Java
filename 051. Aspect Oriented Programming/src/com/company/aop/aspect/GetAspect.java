package com.company.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class GetAspect {

	@Before("com.company.aop.aspect.LoggingFormula.getterDaoMethod()")
	public void beforeGetAdvice() {
		System.out.println("\n-----=====>> Executing get method <<=====-----\n-----=====>> @Before <<=====-----");
	}

	@AfterReturning(pointcut = "execution(* com.company.aop.dao.*.get*(..))", returning = "result")
	public void afterReturningGetAdvice(String result) {
		System.out
				.println("\n-----=====>> Executing get method <<=====-----\n-----=====>> @AfterReturning <<=====-----");
		System.out.println("Returned value is: " + result);
	}

	@AfterThrowing(pointcut = "execution(* com.company.aop.dao.*.get*(..))", throwing = "exception")
	public void afterThrowingGetAdvice(JoinPoint theJoinPoint, Throwable exception) {
		System.out
				.println("\n-----=====>> Executing get method <<=====-----\n-----=====>> @AfterThrowing <<=====-----");
		System.out.println("Returned value is: " + exception);
	}

	@After("com.company.aop.aspect.LoggingFormula.getterDaoMethod()")
	public void afterGetAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n-----=====>> Executing get method <<=====-----\n-----=====>> @After <<=====-----");
		System.out.println("Executed method is: " + theJoinPoint.getSignature().toShortString());
	}
}