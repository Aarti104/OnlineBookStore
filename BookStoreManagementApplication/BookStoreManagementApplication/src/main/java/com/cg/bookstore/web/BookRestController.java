package com.cg.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.service.IBookService;

@RestController
@RequestMapping("/app")
public class BookRestController {
	
	@Autowired
	IBookService bookService;
	
	@PostMapping("/book")
	public boolean addBook(@RequestBody Book b)
	{
		bookService.AddBook(b);
		return true;
	}
	
	@GetMapping("/books")
	public List<Book> bookList()
	{
		return bookService.getAllBooks();
	}
	
	@GetMapping("book/{bookId}")
	public Book getBookId(@PathVariable int bookId)
	{
		return bookService.getBookById(bookId);
	}
	
	@DeleteMapping("/book/{bookId}")
	public boolean deleteBook(@PathVariable int bookId)
	{
		return bookService.deleteBookById(bookId);
	}

}
