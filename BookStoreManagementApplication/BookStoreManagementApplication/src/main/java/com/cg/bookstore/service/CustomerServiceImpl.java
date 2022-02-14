package com.cg.bookstore.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.dto.CustomerOwnerBasicInfoDTO;
import com.cg.bookstore.dto.CustomerSavePostDTO;
import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.Orders;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICustomerRepository;
import com.cg.bookstore.repository.IOrdersRepository;
import com.cg.bookstore.util.CustomerDTOConvertionClass;

@Service
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	ICustomerRepository custRepository;
	
	@Autowired
	IOrdersRepository orderRepo;
	
	@Autowired
	IBookRepository bookRepo;
	
	@Autowired
	CustomerDTOConvertionClass dtoCustConvertion;

	@Override
	public CustomerOwnerBasicInfoDTO saveCustomer(CustomerSavePostDTO customerDto) {
		Customer c=dtoCustConvertion.getCustomerFromPostCustomerDTO(customerDto);
		Customer savedObj=custRepository.save(c);
		CustomerOwnerBasicInfoDTO dtoObj=dtoCustConvertion.getCustomerOwnerBasicDTO(savedObj);
		return dtoObj;
		
	}
	@Override
	public Customer createCustomer(Customer c) {
		return custRepository.save(c);
	}


	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=(List<Customer>) custRepository.findAll();
		return list;
	}

	@Override
	public boolean deleteCustomerById(int customerId) {
		custRepository.deleteById(customerId);
		return true;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return custRepository.findById(customerId).get() ;
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		return custRepository.getCustomerByCity(city);
	}
	
	@Override
	public List<Customer> getCustomerByState(String state) {
		return custRepository.getCustomerByState(state);
	}
	@Override
	public List<Customer> getCustomerByCountry(String country) {
		return custRepository.getCustomerByCountry(country);
	}

	@Override
	@Transactional
	public boolean addOrder(int customerId, int orderId) {
		
		Orders o=orderRepo.findById(orderId).get();
		Customer cust=getCustomerById(customerId);
		if(cust!=null && o!=null)
		{
			List<Orders> or=cust.getOrder();
			or.add(o);
			cust.setOrder(or);
			
		}
		custRepository.save(cust);
		return true;
	}

	@Override
	public boolean addBook(int customerId, int bookId) {
		Book b=bookRepo.findById(bookId).get();
		Customer cust1=getCustomerById(customerId);
		if(cust1!=null && b!=null)
		{
			List<Book> bk=cust1.getBooks();
			bk.add(b);
			cust1.setBooks(bk);
			
		}
		custRepository.save(cust1);
		return true;
	}

	
}
