package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.BankMgmtService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
public class TdTxMgmtProj5AspectjAopSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		ctx=SpringApplication.run(TdTxMgmtProj5AspectjAopSpringBootApplication.class, args);
		
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
