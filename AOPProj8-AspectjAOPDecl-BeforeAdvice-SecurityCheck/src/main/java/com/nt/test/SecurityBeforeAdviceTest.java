package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.BankService;

public class SecurityBeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		AuthenticationManager manager=null;
		//create  IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class obj
		proxy=ctx.getBean("bankService",BankService.class);
		//get AuthenticationManager obj
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		//singnIn
		manager.signIn("raja","rani");
		//invoke b.methods
		System.out.println(proxy.withdraw(1001,2000));
		System.out.println(proxy.deposite(1002,1000));
		
		//signOut
		manager.signOut();
		//close container 
		((AbstractApplicationContext) ctx).close();
	    
	    
	}

}
