package com.nt.service;

public class CarShowRoom {
   public String purchaseCar(String modelname,float price,String color,String executive) {
	   if(price<1000000 && modelname.equalsIgnoreCase("pazero"))
		   return modelname+" "+price+"  "+color+"  "+executive;
	   else
		   return modelname+"  "+price+"  "+color+"  "+executive;
   }
}
