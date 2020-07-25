package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundLoggingAspect {
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
