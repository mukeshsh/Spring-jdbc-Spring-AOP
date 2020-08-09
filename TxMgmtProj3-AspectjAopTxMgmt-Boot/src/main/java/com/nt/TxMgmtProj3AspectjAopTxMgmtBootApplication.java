package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.BankMgmtService;


@SpringBootApplication
public class TxMgmtProj3AspectjAopTxMgmtBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		ctx=SpringApplication.run(TxMgmtProj3AspectjAopTxMgmtBootApplication.class, args);
		//get Service class related Proxy obj
		proxy=ctx.getBean("bankService",BankMgmtService.class);
		try {
			//invoke b.method
			System.out.println(proxy.transferMoney(1003,1001,2000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
