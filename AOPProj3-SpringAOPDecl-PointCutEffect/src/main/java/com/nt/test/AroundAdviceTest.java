package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 

import com.nt.service.IBankService;

public  class AroundAdviceTest {

	public static void main(String[] args) {
      ApplicationContext ctx=null;
      IBankService proxy=null;
      //create IOC Container
      ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      //call getBean to proxy class object
      proxy=ctx.getBean("pfb",IBankService.class);
      System.out.println(Arrays.deepToString(proxy.getClass().getDeclaredMethods()));
      try {
    	  System.out.println("1.Simple Intrest Amount::"+proxy.calcSimpleIntrestAmount(100000,2, 12));
    	  System.out.println("------------------------------------");
    	  System.out.println("2.Simple Intrest Amount::"+proxy.calcSimpleIntrestAmount(9000,2, 12));
    	  System.out.println("=================================================================");
    	  System.out.println("1.Compound Intrest Amount::"+proxy.calcCompoundIntrestAmount(100000,2, 12));
    	  System.out.println("------------------------------------");
    	  System.out.println("2.Compound Intrest Amount::"+proxy.calcCompoundIntrestAmount(8000, 2, 12));
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
      ((AbstractApplicationContext) ctx).close();
	}

}
