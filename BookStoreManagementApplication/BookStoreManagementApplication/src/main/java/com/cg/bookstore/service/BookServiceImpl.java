package com.cg.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	IBookRepository bookRepo;
	
	@Override
	public Book AddBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list=(List<Book>) bookRepo.findAll();
		return list;
	}

	@Override
	public boolean deleteBookById(int bookId) {
		bookRepo.deleteById(bookId);
		return true;
	}

	@Override
	public Book getBookById(int bookId) {
		return bookRepo.findById(bookId).get();
	}

}
