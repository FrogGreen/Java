package com.company.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(42)
public class InputAspect {

	@Before("com.company.aop.aspect.LoggingFormula.otherDaoMethod()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n-----=====>> Input aspect checker <<=====-----\n-----=====>> @Before <<=====-----");

		// Method signature checker
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);

		// Get arguments
		Object[] objects = theJoinPoint.getArgs();
		for (Object object : objects) {
			System.out.println(object);
		}
	}
}