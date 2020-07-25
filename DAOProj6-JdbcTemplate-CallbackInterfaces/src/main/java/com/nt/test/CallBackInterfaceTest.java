package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentMgmtService;

public class CallBackInterfaceTest {

	public static void main(String[] args) {
     ApplicationContext ctx=null;
     StudentDTO dto=null;
     List<StudentDTO> listDTO=null;
     StudentMgmtService service=null;
     //create IOC container
     ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
     //get bean
     service=ctx.getBean("studService",StudentMgmtService.class);
     System.out.println("CallBackInterfaceTest.main()");
     try {
    	 dto=service.fetchStudentById(111);
    	 System.out.println(dto);
     }
     catch(Exception e) {
    	 e.printStackTrace();
    	 System.out.println("Internal Problem");
     }
     System.out.println("--------------------------------------------");
     try {
    	 listDTO=service.fetchStudentById("Varanasi");
    	 listDTO.forEach(System.out::println);
     }
     catch(DataAccessException dae) {
    	 dae.printStackTrace();
     }
   //close container
     ((AbstractApplicationContext) ctx).close();
	}

}
