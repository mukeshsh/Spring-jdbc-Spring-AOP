package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
     
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxy objects
		proxy=ctx.getBean("store", ShoppingStore.class);
		//invoked method..
		try {
			System.out.println("Bill Amount::"+proxy.shopping(new String[] {"Shirt","trousers","Shocks"},new double[] {6000,4000,2000}));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close
		((AbstractApplicationContext) ctx).close();
	}

}
