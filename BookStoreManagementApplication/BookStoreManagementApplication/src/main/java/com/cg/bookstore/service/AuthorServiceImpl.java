package com.cg.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Author;
import com.cg.bookstore.repository.IAuthorRepository;

@Service
public class AuthorServiceImpl implements IAuthorService {
	
	@Autowired
	IAuthorRepository authorRepo;
	@Override
	public Author createAuthor(Author author) {
		return authorRepo.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		List<Author> list=(List<Author>) authorRepo.findAll();
		return list;
	}

	@Override
	public boolean deleteAuthorById(int authorId) {
		authorRepo.deleteById(authorId);
		return true;
	}

	@Override
	public Author getAuthorById(int authorId) {
		return authorRepo.findById(authorId).get();
	}

}
