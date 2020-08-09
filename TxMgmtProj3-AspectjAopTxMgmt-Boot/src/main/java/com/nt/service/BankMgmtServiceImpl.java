package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;


@Service("bankService")
public class BankMgmtServiceImpl implements BankMgmtService {
	
	@Autowired
	private BankDAO dao;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED,timeout =10,rollbackFor = IllegalAccessException.class )
	//@Transactional(propagation = Propagation.REQUIRED,timeout =10,rollbackForClassName ="java.lang.IllegalAccessExeception")
	//@Transactional(propagation = Propagation.REQUIRED,timeout =10,noRollbackFor = IllegalArgumentException.class)
	//@Transactional (propagation=Propagation.REQUIRED,transactionManager = "dxTxMgmr")
	//@Transactional
	//@Transactional(propagation = Propagation.REQUIRED)
	//@Transactional(propagation = Propagation.SUPPORTS)
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	//@Transactional(propagation = Propagation.MANDATORY)
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
	//@Transactional(propagation = Propagation.NEVER)
	@Transactional
	public String transferMoney(int srcAcno, int destAcno, float amt)throws IllegalAccessException {
    int count1=0,count2=0;
    //use dao
    count1=dao.withdraw(srcAcno, amt);
		    /*	try {
			Thread.sleep(20000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
    count2=dao.deposite(destAcno, amt);
    if(count1==0||count2==0)
    	throw new IllegalArgumentException("Problem in money transferring::");
    else
		return amt+" amount of money transfeered from "+srcAcno+" to "+destAcno;
	}

}
