package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor {
	private Map<String, Object> cacheMap=new HashMap();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key=null;
		Object retVal=null;
		//prepare key
		key=invocation.getMethod().getName()+Arrays.deepToString(invocation.getArguments());
		if(!cacheMap.containsKey(key)) {
			retVal=invocation.proceed();//invoked target method and get results
			cacheMap.put(key, retVal); // keeping target method results in caheMap having method name with arg values as the key
			System.out.println("From target Method---");	 
		}
		else {

			retVal=cacheMap.get(key);
			System.out.println("From Cache-----");
		}
		return retVal;
	}
}
