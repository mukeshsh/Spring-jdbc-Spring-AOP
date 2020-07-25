package com.nt.advice;

import com.nt.manager.AuthenticationManager;

public class SecurityCheckAdvice {
   
	private AuthenticationManager manager;

	public SecurityCheckAdvice(AuthenticationManager manager) {
		this.manager = manager;
	}

	/*public void checkCredentials(JoinPoint jp) throws Throwable {
		System.out.println(jp.getSignature()+" with args"+Arrays.toString(jp.getArgs()));
		   if(!manager.validate())
			   throw new IllegalAccessException("Invalid Credetails");
	
	}*/
	
	public void checkCredentials(int acid,float amount) throws Throwable {
	       System.out.println("arg values are::"+acid+"  "+amount);
		   if(!manager.validate())
			   throw new IllegalAccessException("Invalid Credetails");
	
	}
}
