package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.BankMgmtService;

@SpringBootApplication
public class TdTxMgmtProj7AspectjAopSpringBootYmlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		ctx=SpringApplication.run(TdTxMgmtProj7AspectjAopSpringBootYmlApplication.class, args);

		//get Proxy oject
		proxy=ctx.getBean("bankService",BankMgmtService.class);
		//System.out.println(proxy.getClass()+"  "+proxy.getClass().getSuperclass());
		try {
			//invoke method
			System.out.println(proxy.transferMoney(1001, 1004,4000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		//close container
		((ConfigurableApplicationContext) ctx).close();
	}
}

