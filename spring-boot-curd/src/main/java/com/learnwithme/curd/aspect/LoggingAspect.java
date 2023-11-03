package com.learnwithme.curd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.learnwithme.curd*.*(..))")
	 public void logMethodEntry(JoinPoint joinPoint) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.debug("Entering method: " + joinPoint.getSignature());
    }
	
	@After("execution(* com.learnwithme.curd*.*(..))")
	 public void logMethodExit(JoinPoint joinPoint) {
       Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
       logger.debug("Exiting method: " + joinPoint.getSignature());
   }
}
