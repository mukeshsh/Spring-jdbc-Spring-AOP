package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
  private EmployeeDAO dao;
  
	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
	System.out.println("----------");
	this.dao = dao;
}

	@Override
	public int fetchEmpsCount() {
		int count=0;
		//use dao
		count=dao.getEmpsCount();
		return count;
	}

	@Override
	public String fetchEmpNameByNo(int empNo) {
      String name=null;
      //use DAO
      name=dao.getEmpNameByNo(empNo);
		return name;
	}

	@Override
	public Map<String, Object> fetchEmpBySal(float no) {
		Map<String, Object> map=null;
		//use dao
		map=dao.getEmpyByNo(no);
		return map;
	}

	@Override
	public List<Map<String, Object>> fetchEmpsByDesg(String desg) {
     List<Map<String,Object>>list=null;
     //use dao
     list=dao.getEmpByDesg(desg);
		return list;
	}

	@Override
	public String register(int eno,String name, String desg, float salary) {
		int count=0; 
		//use dao
		count=dao.insert(eno,name, desg, salary);
		if(count==0)
			return "Employees Registration Failed";
		else
		return "Registration Succeeded";
	}
	public String hikeEmpSalaryBySalRange(float salaryRange, float percentage) {
		int count=0;
		//use DAO
		count=dao.updateSalary(salaryRange, percentage);
		return count+" no.of Employess salary is hiked";
	}
	
	public String fireEmpsBySalaryRange(float start, float end) {
		int count=0;
	   //use DAOs
		count=dao.deleteEmployeesBySalaryRange(start, end);
		return count+" no.of employess are fired";
	}

}
