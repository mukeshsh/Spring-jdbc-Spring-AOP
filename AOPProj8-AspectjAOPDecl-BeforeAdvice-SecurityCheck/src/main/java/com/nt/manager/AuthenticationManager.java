package com.nt.manager;

import org.springframework.beans.BeanUtils;

import com.nt.bo.UserDetailsBO;
import com.nt.dao.AuthenticateDAO;
import com.nt.dto.UserDetailsDTO;

public class AuthenticationManager {
	private ThreadLocal<UserDetailsDTO>  threadLocal=new ThreadLocal();
	private  AuthenticateDAO  dao;
	
	public AuthenticationManager(AuthenticateDAO dao) {
		this.dao = dao;
	}


	//keeps given username and passwords in ThreadLocal as UserDetails obj
	public  void signIn(String username,String password) {
		UserDetailsDTO details=null;
		details=new UserDetailsDTO();
		details.setUsername(username);
		details.setPwd(password);
		threadLocal.set(details);
	}
	
	
	//remove  userDetails obj from ThreadLocal object
	public  void signOut() {
		threadLocal.remove();
	}
	
	public  boolean isAuthenticated() {
		UserDetailsDTO dto=null;
		UserDetailsBO bo=null;
		int count=0;
		//get Current client's/thread's UserDetailsDTO class object
		dto=threadLocal.get();
		//convert dto to bo
		bo=new UserDetailsBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.validate(bo);
		return count==0?false:true;
		
	}
}
