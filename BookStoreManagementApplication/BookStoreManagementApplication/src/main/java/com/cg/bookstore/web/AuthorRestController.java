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

import com.cg.bookstore.entity.Author;
import com.cg.bookstore.service.IAuthorService;

@RestController
@RequestMapping("/app")
public class AuthorRestController {
	
	@Autowired
	IAuthorService authorService;
	
	@PostMapping("/author")
	public boolean createAuthor(@RequestBody Author a)
	{
		authorService.createAuthor(a);
		return true;
	}
	
	@GetMapping("/authors")
	public List<Author> listAuthors()
	{
		return authorService.getAllAuthors();
	}
	
	@GetMapping("/author/{authorId}")
	public Author getAuthorId(@PathVariable int authorId)
	{
		return authorService.getAuthorById(authorId);
	}
	
	@DeleteMapping("/author/{authorId}")
	public boolean deleteAuthor(@PathVariable int authorId)
	{
		return authorService.deleteAuthorById(authorId);
		
	}
}
