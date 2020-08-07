package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class UseAccessAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Weaving and weaver
	@AfterReturning(
			value="execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))",
			returning="result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} return with value {}", joinPoint, result);
	}
	
	// Weaving and weaver
	@After(value="execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {} ", joinPoint);
	}
}
