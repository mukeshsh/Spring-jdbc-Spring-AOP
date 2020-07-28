package com.nt.test;

import java.sql.SQLException;

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
		manager.signIn("karishma","anil");
		//invoke b.methods
		try {
		System.out.println(proxy.withdraw(1002,2000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------");
		try {
			System.out.println(proxy.deposite(1003,2000));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		//signOut
		manager.signOut();
		//close container 
		((AbstractApplicationContext) ctx).close();
	    
	    
	}

}
