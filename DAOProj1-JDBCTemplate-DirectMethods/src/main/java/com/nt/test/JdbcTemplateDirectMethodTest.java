package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeMgmtService;

public class JdbcTemplateDirectMethodTest {

	public static void main(String[] args) {
     ApplicationContext ctx=null;
     EmployeeMgmtService service=null;
     //create  IOC container
     ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
     //get service class object
     service=ctx.getBean("empService",EmployeeMgmtService.class);
     try {
    	 System.out.println("Employee Count::"+service.fetchEmpsCount());
     }
     catch(DataAccessException dae) {
    	 dae.printStackTrace();
    	 System.out.println("Internal Problem");
     }
     System.out.println("------------------------------------------------");
     try {
    	 System.out.println("7499 Details Employee::"+service.fetchEmpNameByNo(7499));
     }
     catch(DataAccessException dae) {
    	 dae.printStackTrace();
    	 System.out.println("Internal Problem");
     }
     System.out.println("-------------------------------------------------");
     try {
    	 System.out.println("Based on salary details are::"+service.fetchEmpBySal(4600));
     }
     catch(DataAccessException dae) {
    	 dae.printStackTrace();
    	 System.out.println("Internal problem");
     }
     System.out.println("------------------------------");
     try {
    	 System.out.println("Manager Desg Employees::"+service.fetchEmpsByDesg("CLERK"));
     }
     catch(DataAccessException dae) {
    	 dae.printStackTrace();
    	 System.out.println("-----------------------");
     }
		/*
		 * System.out.println("-----------------------------"); try {
		 * System.out.println(service.register(3478,"Amitabh", "Actor", 7890)); }
		 * catch(DataAccessException dae) { dae.printStackTrace();
		 * System.out.println("Internal Exception"); }
		 */
		/*
		 * System.out.println("-----------------------------"); try {
		 * System.out.println(service.hikeEmpSalaryBySalRange(4500, 20)); }
		 * catch(DataAccessException dae) { dae.printStackTrace();
		 * System.out.println("Internal Exception"); }
		 */
     System.out.println("-----------------------------");
     try {
    	 System.out.println(service.fireEmpsBySalaryRange(20000, 30000));
     }
     catch(DataAccessException dae) {
    	 dae.printStackTrace();
    	 System.out.println("Internal Exception");
     }
	}

}
