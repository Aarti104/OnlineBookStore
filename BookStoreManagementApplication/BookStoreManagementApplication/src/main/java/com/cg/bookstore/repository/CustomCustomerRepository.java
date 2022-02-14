package com.cg.bookstore.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.bookstore.dto.CustomerSavePostDTO;
import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;

@Repository
public interface CustomCustomerRepository {
	
	public List<Customer> getCustomerByCity(String city);
	public List<Customer> getCustomerByState(String state);
	public List<Customer> getCustomerByCountry(String country);
	

}
