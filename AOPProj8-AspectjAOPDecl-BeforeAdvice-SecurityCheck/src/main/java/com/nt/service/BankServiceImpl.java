package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceImpl implements BankService {
  private BankDAO dao;
  
	public BankServiceImpl(BankDAO dao) {
	this.dao = dao;
}

	@Override
	public String withdraw(int acno, float amt) {
   int count=0;
   //use dao
   count=dao.withdraw(acno, amt);
   if(count==0)
	   return "Money Not Withdraw(Account no Invalid)";
   else
		return "Money withdraw from account"+acno;
	}

	@Override
	public String deposite(int acno, float amt) {
		  int count=0;
		   //use dao
		   count=dao.deposite(acno, amt);
		   if(count==0)
			   return "Money Not Deposite(Account no Invalid)";
		   else
				return "Money deposited into account"+acno;
			}
	}
