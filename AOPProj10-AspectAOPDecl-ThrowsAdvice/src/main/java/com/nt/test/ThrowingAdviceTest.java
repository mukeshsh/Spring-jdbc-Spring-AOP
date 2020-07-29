package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.errors.InternalProblemException;
import com.nt.service.ShoppingStore;

public class ThrowingAdviceTest {

	public static void main(String[] args) {
      
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//create IOC Conatainer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		proxy=ctx.getBean("shopping", ShoppingStore.class);
		//invoked method
		try {
			System.out.println("Bill Amount is::"+proxy.calculateSingleProdBillAmt(10000, 2));
		}
		/*catch(IllegalArgumentException iae) {
		iae.printStackTrace();
	}
	*/
	  /*catch(IllegalAccessException iae) {
		iae.printStackTrace();
	  }*/
		catch(InternalProblemException ipe) {
			ipe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------");
		try {
			System.out.println("Bill Amount is::"+proxy.calculateSingleProdBillAmt(10000, 0));
		}
		/*catch(IllegalArgumentException iae) {
		iae.printStackTrace();
	     }*/
		catch(InternalProblemException ipe) {
			ipe.printStackTrace();
		}
		/*catch(IllegalAccessException iae) {
		iae.printStackTrace();
	   }*/
		catch(Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}
}
