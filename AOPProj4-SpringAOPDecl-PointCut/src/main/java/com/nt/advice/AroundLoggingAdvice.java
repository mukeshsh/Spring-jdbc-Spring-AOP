package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object args[]=null;
		System.out.println("Entering into "+invocation.getMethod().getName()+"with args "+Arrays.deepToString(invocation.getArguments()));
		//to modify target method args values
		args=invocation.getArguments();
		if((float)args[0]<50000)
			args[1]=(float)args[1]-0.5f;
		
		if((float)args[0]<0||(float)args[1]<0||(float)args[2]<0)
			throw new IllegalAccessException("Invalid input");
		else 
			retVal=invocation.proceed();
		
		System.out.println("Entering into"+invocation.getMethod().getName()+"with args "+Arrays.deepToString(invocation.getArguments()));
		//to modify target return values..
		retVal=(float)retVal+(float)retVal*0.5f;
		return retVal;
	}

}
