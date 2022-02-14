package com.cg.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Author;

@Service
public interface IAuthorService {
	
	public Author createAuthor(Author author);
	public List<Author> getAllAuthors();
	public boolean deleteAuthorById(int authorId);
	public Author getAuthorById(int authorId);

}
