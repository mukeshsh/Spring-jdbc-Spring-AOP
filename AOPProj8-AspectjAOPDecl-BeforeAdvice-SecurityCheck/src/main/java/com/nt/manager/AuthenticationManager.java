package com.nt.manager;

import com.nt.dao.AuthenticateDAO;
import com.nt.model.UserDetails;

public class AuthenticationManager {
	private ThreadLocal<UserDetails>  threadLocal=new ThreadLocal();
	private  AuthenticateDAO  dao;
	
	public AuthenticationManager(AuthenticateDAO dao) {
		this.dao = dao;
	}


	//keeps given username and passwords in ThreadLocal as UserDetails obj
	public  void signIn(String username,String password) {
		UserDetails details=null;
		details=new UserDetails();
		details.setUsername(username);
		details.setPassword(password);
		threadLocal.set(details);
	}
	
	
	//remove  userDetails obj from ThreadLocal object
	public  void signOut() {
		threadLocal.remove();
	}
	
	public   boolean  validate() {
		UserDetails details=null;
		int count=0;
		//get current client /thread related details from ThreadLocal
		details=threadLocal.get();
		//use DAO
		count=dao.authenticate(details);
		if(count==0)
			return false;
		else
			return true;
	}
}
