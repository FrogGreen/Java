package com.company.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.company.entity.Person;
import com.sun.istack.logging.Logger;

@Aspect
@Component
public class LogginAspect {

	private Logger logger = Logger.getLogger(Person.class);

	@Pointcut("execution(* com.company.controller.*.*(..))")
	private void controllerPackage() {
	}

	@Pointcut("execution(* com.company.dao.*.*(..))")
	private void daoPackage() {
	}

	@Pointcut("execution(* com.company.service.*.*(..))")
	private void servicePackage() {
	}

	@Pointcut("controllerPackage() || daoPackage() || servicePackage()")
	private void appFlow() {
	}

	@Before("appFlow()")
	public void beforeAppFlow(JoinPoint joinPoint) {
		String string = joinPoint.getSignature().toShortString();
		logger.info("\n-----=====>> Executing @Before call method <<=====-----");
		logger.info("\n-----=====>> " + string + " <<=====-----");

		Object[] objects = joinPoint.getArgs();
		for (Object object : objects) {
			logger.info(object.toString());
		}
	}

	@AfterReturning(pointcut = "appFlow()", returning = "result")
	public void afterAppFlow(JoinPoint joinPoint, Object result) {
		String string = joinPoint.getSignature().toShortString();
		logger.info("\n-----=====>> Executing @AfterReturning call method <<=====-----");
		logger.info("\n-----=====>> " + string + " <<=====-----");
		logger.info("\n-----=====>> " + result + " <<=====-----");
	}
}