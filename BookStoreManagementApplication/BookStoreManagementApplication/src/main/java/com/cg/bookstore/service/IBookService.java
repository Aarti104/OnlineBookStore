package com.cg.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Book;

@Service
public interface IBookService {
	
	public Book AddBook(Book book);
	public List<Book> getAllBooks();
	public boolean deleteBookById(int bookId);
	public Book getBookById(int bookId);
	

}
