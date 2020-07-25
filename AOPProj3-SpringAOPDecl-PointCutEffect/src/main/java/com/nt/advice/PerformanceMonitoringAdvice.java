package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("PerformenceMonitoringAdvice.invoke()"+invocation.getClass());
		long start=0,end=0;
		Object retVal=null;
		if(invocation.getMethod().getName().equalsIgnoreCase("calcSimpleIntrestAmount")) {
			System.out.println("pre");
			start=System.currentTimeMillis(); //pre-logic
			retVal=invocation.proceed(); //invokes the method
			System.out.println("post");
			end=System.currentTimeMillis(); //post logic
			System.out.println(invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments())+" has taken "+(end-start)+" ms");
		}
		/*
		 * else if(invocation.getMethod().getName().equalsIgnoreCase(
		 * "calcCompoundIntrestAmount")) { System.out.println("pre");
		 * start=System.currentTimeMillis(); //pre-logic retVal=invocation.proceed();
		 * //invokes the method System.out.println("post");
		 * end=System.currentTimeMillis(); //post logic
		 * System.out.println(invocation.getMethod().getName()+" with args "+Arrays.
		 * toString(invocation.getArguments())+" has taken "+(end-start)+" ms"); }
		 */
		else {
			retVal=invocation.proceed();
		}
		return retVal;
	}
}

