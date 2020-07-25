package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;
@Service("studService")
public class StudentMgmtServiceImpl implements StudentMgmtService {
   @Autowired
	private StudentDAO dao;
	@Override
	public StudentDTO fetchStudentById(int no) {
   StudentDTO dto=null;
   StudentBO bo=null;
   //use dao
   bo=dao.getStudentById(no);
   //convert bo to dto
   dto=new StudentDTO();
   BeanUtils.copyProperties(bo, dto);
   return dto;
	}
	@Override
	public List<StudentDTO> fetchStudentById(String addrs) {
      List<StudentBO> listBO=null;
      List<StudentDTO> listDTO=new ArrayList();
      //use dao
      listBO=dao.getStudentByAddrs(addrs);
      listBO.forEach(bo->{
    	  StudentDTO dto=new StudentDTO();
    	  BeanUtils.copyProperties(bo, dto,"savg");
    	  dto.setSavg(Math.round(bo.getSavg()));
    	  dto.setSrNo(listDTO.size()+1);
      });	
		return listDTO;
	}

}
