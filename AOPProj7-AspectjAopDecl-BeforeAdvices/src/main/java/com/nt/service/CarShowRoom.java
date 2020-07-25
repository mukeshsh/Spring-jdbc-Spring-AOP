package com.nt.service;

public class CarShowRoom {
   public String purchaseCar(String modelname,float price,String color,String executive) {
	   if(price<9000000 && modelname.equalsIgnoreCase("pazero"))
		   return modelname+" "+price+"  "+color+"  "+executive;
	   else
		   return modelname+"  "+price+"  "+color+"  "+executive;
   }
}
