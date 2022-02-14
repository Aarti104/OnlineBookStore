package com.cg.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.bookstore.entity.Book;

public interface IBookRepository extends CrudRepository<Book,Integer>,CustomBookRepository {

}
