package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
  public int getEmpsCount();
  public String getEmpNameByNo(int no);
  public Map<String, Object>getEmpyByNo(float no);
  public List<Map<String, Object>> getEmpByDesg(String desg);
  public  int  insert(int eno,String ename,String desg, float salary);
  public  int  updateSalary(float salRange,float percentage);
  public  int deleteEmployeesBySalaryRange(float start,float end);
}
