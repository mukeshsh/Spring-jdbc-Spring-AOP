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
		return amt+"  Money withdraw from account  "+acno+" account";
	}

	@Override
	public String deposite(int acno, float amt) {
		  int count=0;
		   //use dao
		   count=dao.deposite(acno, amt);
			    return (count==0)?"Money not Deposited":"Money is  deposited from "+acno+"  account";
			}
	}
