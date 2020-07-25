package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;
@Repository("studDAO")
public class StudentDAOImpl implements StudentDAO {
	private static final String Get_Student_by_No="SELECT SNO,SNAME,SADD,SAVG FROM STUDENT WHERE SNO=? ";
	private static final String GET_STUDENT_BY_ADDRS="SELECT SNO,SNAME,SADD,SAVG FROM STUDENT WHERE SADD=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentById(int no) {
		StudentBO bo1=null;
		bo1=jt.queryForObject(Get_Student_by_No,
				              (rs,index)->{
									StudentBO bo=null;
									//copy ResultSet object records  BO class obbj
									bo=new StudentBO();
									bo.setSno(rs.getInt(1));
									bo.setSname(rs.getString(2));
									bo.setSadd(rs.getString(3));
									bo.setSavg(rs.getFloat(4));
									return bo;
								}//mapRow(-)
			                     ,
				             no);
		
		return bo1;
		}

	@Override
	public List<StudentBO> getStudentByAddrs(String addrs) {
		List<StudentBO> listBO=null;
		listBO=jt.query(GET_STUDENT_BY_ADDRS, new ResultSetExtractor<List<StudentBO>>() {
			@Override
			public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			  System.out.println("StudentDAOImpl.getStudentByAddrs(...).new ResultSetExtractor() {...}.extractData()");
			  List<StudentBO> listBO1=null;
			  StudentBO bo=null;
			  listBO1=new ArrayList();
			  while(rs.next()) {
				  //copy resultset records to listbo objects
				  bo=new StudentBO();
				  bo.setSno(rs.getInt(1));
				  bo.setSname(rs.getString(2));
				  bo.setSadd(rs.getString(3));
				  bo.setSavg(rs.getFloat(4));
				  listBO1.add(bo);
			  }
				return listBO1;
			}//extract data
		},
		addrs);
		return listBO;
	}
	}

