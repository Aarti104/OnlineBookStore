package com.cg.bookstore.repository;

import com.cg.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer,Integer> ,CustomCustomerRepository
{
	
}
