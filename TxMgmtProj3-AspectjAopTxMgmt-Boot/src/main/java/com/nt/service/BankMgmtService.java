package com.nt.service;

public interface BankMgmtService {
    public String transferMoney(int srcAcno,int destAcno,float amt)throws IllegalAccessException;
}
