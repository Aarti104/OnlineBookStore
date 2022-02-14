package com.cg.bookstore.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.dto.CustomerOwnerBasicInfoDTO;
import com.cg.bookstore.dto.CustomerSavePostDTO;
import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.service.ICustomerService;
import com.cg.bookstore.util.CustomerDTOConvertionClass;

@RestController
@RequestMapping("/app")
@Validated
public class CustomerRestController {
	
	@Autowired
	ICustomerService custService;
	
	
	@PostMapping("/customerdto")
	public ResponseEntity<CustomerOwnerBasicInfoDTO> saveCustomer(@RequestBody @Valid CustomerSavePostDTO c)
	{
		CustomerOwnerBasicInfoDTO dto=custService.saveCustomer(c);
		return new ResponseEntity<CustomerOwnerBasicInfoDTO>(dto,HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public boolean createCustomer(@RequestBody @Valid Customer c)
	{
		custService.createCustomer(c);
		return true;
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomerId(@PathVariable int customerId)
	{
		return custService.getCustomerById(customerId);
	}
	
	@GetMapping("/customers")
	public List<Customer> listCustomers()
	{
		return custService.getAllCustomers();
	}
	
	@DeleteMapping("/customer/{customerId}")
	public boolean deleteCustomer(@PathVariable int customerId) {
		return custService.deleteCustomerById(customerId);
	}
	
	@GetMapping("/customercity")
	public List<Customer> getCustomerCity(@RequestParam String city)
	{
		return custService.getCustomerByCity(city);
	}
	
	@GetMapping("/customerstate")
	public List<Customer> getCustomerState(@RequestParam String state)
	{
		return custService.getCustomerByState(state);
	}
	
	@GetMapping("/customercountry")
	public List<Customer> getCustomerCountry(@RequestParam String country)
	{
		return custService.getCustomerByCountry(country);
	}
	
	@PostMapping("/custorder")
	//localhost:8091/app/custorder?orderId=1&customerId=1201
	public ResponseEntity<Boolean> addOrder(@RequestParam int orderId,@RequestParam int customerId)
	{
		boolean a=custService.addOrder(customerId, orderId);
		return new ResponseEntity<Boolean>(a,HttpStatus.OK);
	}
	
	@PostMapping("/custbook")
	//localhost:8091/app/custbook?bookId=1001&customerId=1201
	public ResponseEntity<Boolean> addBook(@RequestParam int bookId,@RequestParam int customerId)
	{
		boolean a=custService.addBook(customerId, bookId);
		return new ResponseEntity<Boolean>(a,HttpStatus.OK);
	}
}
