package com.cg.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.bookstore.entity.Author;


public interface IAuthorRepository extends CrudRepository<Author,Integer>,CustomAuthorRepository{

}
