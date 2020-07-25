package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.BookDTO;
import com.nt.service.BookStoreMgmtService;

public class NamedParameterJdbcTemplate {

	public static void main(String[] args) {

		ApplicationContext ctx=null;
		BookStoreMgmtService service=null;
		List<BookDTO> listDTO=null;
		BookDTO dto=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service class object
		service=ctx.getBean("bookStoreService",BookStoreMgmtService.class);
		try {
			//invoked b.method
			listDTO=service.fetchBooksByAuthor("RJ", "BE", "JB");
			listDTO.forEach(System.out::println);

		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("--------------------------------------------------");
		try {
			dto=new BookDTO();
			dto.setBookName("SpringBoot");dto.setAuthor("Raghu");dto.setPrice(850);
			dto.setPublisher("NareshIT");dto.setStatus("yes");dto.setCategory("java");
			System.out.println(service.addBook(dto));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}
}
