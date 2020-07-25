package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CarShowRoom room=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext1.xml");
		room=ctx.getBean("showcar", CarShowRoom.class);
		try {
			System.out.println(room.purchaseCar("pazero", 100000, "red", "Mukesh"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
