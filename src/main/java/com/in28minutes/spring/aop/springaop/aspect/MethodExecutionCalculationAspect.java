package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();;
		
		try {
			joinPoint.proceed();
			long timeTaken = System.currentTimeMillis() - startTime;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
}
