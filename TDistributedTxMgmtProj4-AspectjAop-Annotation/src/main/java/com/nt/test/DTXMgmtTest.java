package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankMgmtService;

public class DTXMgmtTest {

	
	public static void main(String[] args) {
    ApplicationContext ctx=null;
    BankMgmtService proxy=null;
    ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    proxy=ctx.getBean("bankService", BankMgmtService.class);
    try {
    	System.out.println(proxy.transferMoney(1002, 1004, 2000));
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
    ((AbstractApplicationContext) ctx).close();
	}

}
