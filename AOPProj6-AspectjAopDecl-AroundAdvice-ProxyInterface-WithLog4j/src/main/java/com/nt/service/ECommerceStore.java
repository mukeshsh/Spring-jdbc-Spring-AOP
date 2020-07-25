package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dto.ProductDTO;

public class ECommerceStore implements IECommerceStore {
   private List<ProductDTO> cartList=new ArrayList();
   //method
   public String addItemToCart(ProductDTO dto) {
	   cartList.add(dto);
	   return dto.getPname()+ "is added to cart";
   }
   //method 2
   public void showCartItems() {
	   System.out.println("All Item is Added to The Cart");
	   cartList.forEach(System.out::println);
   }
   //method 3
   public float calcBillAmount(float cuponDiscount) {
	   System.out.println("ECommerceStore.calcBillAmount()"+cuponDiscount);
	   float bamt=0.0f;
	   float finalAmt=0.0f;
	   bamt=(float)cartList.stream().mapToDouble(dto->
       dto.getPrice()*dto.getQty()).sum();
	    finalAmt=bamt-(bamt*(cuponDiscount/100.0f));
	    return finalAmt;
   }

}
