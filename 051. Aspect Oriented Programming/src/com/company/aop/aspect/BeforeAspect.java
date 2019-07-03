package com.company.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class BeforeAspect {

	@Before("com.company.aop.aspect.LoggingFormula.otherDaoMethod()")
	public void firstBeforeAdvice() {
		System.out.println("\n-----=====>> Executing first time @Before call method <<=====-----");
	}

	@Before("com.company.aop.aspect.LoggingFormula.otherDaoMethod()")
	public void secondBeforeAdvice() {
		System.out.println("-----=====>> Executing second time @Before call method <<=====-----");
	}
}