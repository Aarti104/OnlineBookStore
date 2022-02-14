package com.cg.bookstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bookstore.dto.CustomerOwnerBasicInfoDTO;
import com.cg.bookstore.dto.CustomerSavePostDTO;
import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;

@Service
public interface ICustomerService {
	
	public CustomerOwnerBasicInfoDTO saveCustomer(CustomerSavePostDTO customerDto);
	public Customer createCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public boolean deleteCustomerById(int customerId);
	public Customer getCustomerById(int customerId);
	
	public List<Customer> getCustomerByCity(String city);
	public List<Customer> getCustomerByState(String state);
	public List<Customer> getCustomerByCountry(String country);
	
	public boolean addOrder(int customerId,int orderId);
	public boolean addBook(int customerId,int bookId);
	

}
