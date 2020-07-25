package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
  private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
  private static final String GET_EMP_BY_NAME="SELECT ENAME FROM EMP WHERE EMPNO=?";
  private static final String GET_EMPS_BY_SAL="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=?";
  private static final String GET_EMPS_DETAILS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
  private static final String  INSERT_EMPS_DETAILS="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
  private static final String UPDATE_EMP_SALARY_BY_SALARYRANGE="UPDATE EMP SET SAL=SAL+(SAL*?) WHERE SAL<?";
  private static final String DELETE_EMP_BY_SALARYRANGER="DELETE FROM EMP WHERE SAL>=? and SAL<=?";
  @Autowired
  private JdbcTemplate jt;
	

	@Override
	public int getEmpsCount() {
     int count=0;
     count=jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

	@Override
	public String getEmpNameByNo(int no) {
		String name=null;
		name=jt.queryForObject(GET_EMP_BY_NAME, String.class,no);
		return name;
	}
  @Override
	public Map<String, Object> getEmpyByNo(float no) {
     Map<String, Object>map=null;
     map=jt.queryForMap(GET_EMPS_BY_SAL,no);
		return map;
	}

@Override
public List<Map<String, Object>> getEmpByDesg(String desg) {
	List<Map<String,Object>> list=null;
	list=jt.queryForList(GET_EMPS_DETAILS_BY_DESG,desg);
	return list;
}

@Override
public int insert(int eno,String ename, String desg, float salary) {
    int count=0;
    count=jt.update(INSERT_EMPS_DETAILS,eno,ename,desg,salary);
	return count;
}
public int updateSalary(float salRange, float Percentage) {
	   int count=0;
	   count=jt.update(UPDATE_EMP_SALARY_BY_SALARYRANGE,(Percentage/100.0f),salRange);
	   return count;
	}
	
	public int deleteEmployeesBySalaryRange(float start, float end) {
		int count=0;
		count=jt.update(DELETE_EMP_BY_SALARYRANGER, start,end);
	    return count;
	}
}
