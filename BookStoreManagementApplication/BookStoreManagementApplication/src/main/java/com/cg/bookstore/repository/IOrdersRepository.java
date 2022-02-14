package com.cg.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.bookstore.entity.Orders;

public interface IOrdersRepository extends CrudRepository<Orders,Integer>,CustomOrdersRepository{

}
