package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAdvice")
@Aspect
public class PerformanceMonitoringAspect {
	@Around(value="execution(* com.nt.service.ECommerceStore.*(..))")
	@Order(1)
       public Object monitor(ProceedingJoinPoint pjp) throws Throwable{
    	   long start=0,end=0;
    	   Object retVal=null;
    	   start=System.currentTimeMillis();
    	   retVal=pjp.proceed();
    	   end=System.currentTimeMillis();
    	   System.out.println(pjp.getSignature()+"with args "+Arrays.deepToString(pjp.getArgs())+"has taken "+(end-start)+"ms");
    	   return retVal;
       }
    
}
