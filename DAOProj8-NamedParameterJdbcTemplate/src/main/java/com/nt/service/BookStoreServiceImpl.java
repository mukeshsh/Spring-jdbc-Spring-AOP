package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BookBO;
import com.nt.dao.BookStoreDAO;
import com.nt.dto.BookDTO;
@Service("bookStoreService")
public class BookStoreServiceImpl implements BookStoreMgmtService {
  @Autowired
	private BookStoreDAO dao;
	@Override
	public List<BookDTO> fetchBooksByAuthor(String author1, String author2, String author3) {
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=new ArrayList();
		//use service
		listBO=dao.findBooksByAuthor(author1, author2, author3);
		//convert ListBO to ListDto
		listBO.forEach(bo->{
			BookDTO dto=new BookDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
	@Override
	public String addBook(BookDTO dto) {
		BookBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new BookBO();
		BeanUtils.copyProperties(dto, bo, "bookid");
		//use dao
		count=dao.insertBook(bo);
		return count==0?"Book Insertion failed":"Book Insertion Succeded";
	}

}
