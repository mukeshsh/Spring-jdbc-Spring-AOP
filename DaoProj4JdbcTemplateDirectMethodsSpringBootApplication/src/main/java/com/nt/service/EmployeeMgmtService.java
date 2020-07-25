package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {
  public int fetchEmpsCount();
  public String fetchEmpNameByNo(int empNo);
  public Map<String, Object> fetchEmpBySal(float no);
  public List<Map<String, Object>> fetchEmpsByDesg(String desg);
  public String register(int eno,String name,String desg,float salary);
  public  String hikeEmpSalaryBySalRange(float salaryRange,float percentage);
  public  String fireEmpsBySalaryRange(float start,float end);
}
