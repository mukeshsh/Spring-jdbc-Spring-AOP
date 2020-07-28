package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.UserDetailsBO;

public class AuthenticateDAOImpl implements AuthenticateDAO {
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND UPWD=?";
	private JdbcTemplate jt;

	public AuthenticateDAOImpl(JdbcTemplate jt) {
		System.out.println("AuthenticateDAOImpl::1-param constructor");
		this.jt = jt;
	}


	@Override
	public int validate(UserDetailsBO bo) {
		int count=0;
		count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUsername(),bo.getPwd());
		return count;
	}

}
