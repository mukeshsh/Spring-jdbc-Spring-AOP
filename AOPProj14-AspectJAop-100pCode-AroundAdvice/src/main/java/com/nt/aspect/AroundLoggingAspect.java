package com.nt.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("logAdvice")
@Aspect
public class AroundLoggingAspect {
	private static Logger logger=Logger.getLogger(AroundLoggingAspect.class);
	static {
		try {
			PropertyConfigurator.configure("src/main/java/com/nt/commons/log4j.properties");
			logger.info("Log4j activated");
		}
		catch(Exception e) {
			logger.fatal("unknown log4j problem");
			e.printStackTrace();
		}
	}
	@Around("execution(* com.nt.service.ECommerceStore.*(..))")
	@Order(5)
    public Object logging(ProceedingJoinPoint pjp) throws Throwable{
    	Object retVal=null;
    	Object args[]=null;
    	System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.deepToString(pjp.getArgs()));
    	args=pjp.getArgs();
    	if(pjp.getSignature().getName().equalsIgnoreCase("calcBillAmount")) {
    		args[0]=(Float)args[0]+1;
    	}
    	retVal=pjp.proceed(args);
    	System.out.println("Existing into "+pjp.getSignature()+"with args "+Arrays.deepToString(pjp.getArgs()));
    	return retVal;
    }
}
