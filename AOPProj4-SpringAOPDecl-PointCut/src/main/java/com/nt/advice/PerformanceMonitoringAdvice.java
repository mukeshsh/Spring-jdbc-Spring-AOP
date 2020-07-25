package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start=0,end=0;
		Object retVal=null;
		System.out.println("pre");
		start=System.currentTimeMillis();
		retVal=invocation.proceed();
		System.out.println("post");
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		return retVal;
	}
}
