package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.BankMgmtService;

public class TransactionManagementTest {

	public static void main(String[] args) {
    ApplicationContext context=null;
    BankMgmtService proxy=null;
    //create ioc container
    context=new ClassPathXmlApplicationContext("cfgs/applicationContext.xml");
    //get Proxy object
    proxy=context.getBean("bankService", BankMgmtService.class);
    System.out.println(proxy.getClass()+"    "+proxy.getClass().getSuperclass());
    try {
    	System.out.println(proxy.transferMoney(1004, 1002, 1000));
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
    //close conn
    ((AbstractApplicationContext) context).close();
	}

}
