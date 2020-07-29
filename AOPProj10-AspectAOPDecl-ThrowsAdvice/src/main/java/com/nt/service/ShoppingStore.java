package com.nt.service;

public class ShoppingStore {
    public float calculateSingleProdBillAmt(float price,float quantity) throws IllegalAccessException{
    	if(quantity<=0.0f||price<=0.0f)
    		throw new IllegalAccessException("Invalid input");
    	return price*quantity;
    }
}
