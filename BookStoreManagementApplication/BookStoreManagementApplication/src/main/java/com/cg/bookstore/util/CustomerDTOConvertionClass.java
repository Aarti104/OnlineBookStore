package com.cg.bookstore.util;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.cg.bookstore.dto.CustomerOwnerBasicInfoDTO;
import com.cg.bookstore.dto.CustomerSavePostDTO;
import com.cg.bookstore.entity.Customer;

@Component
public class CustomerDTOConvertionClass {
	
	public CustomerOwnerBasicInfoDTO getCustomerOwnerBasicDTO(Customer customer)
	{
		CustomerOwnerBasicInfoDTO dtoObj=new CustomerOwnerBasicInfoDTO();
		dtoObj.setCustomerId(customer.getCustomerId());
		dtoObj.setCustomerName(customer.getCustomerName());
		dtoObj.setEmail(customer.getEmail());
		dtoObj.setPassword(customer.getPassword());
		dtoObj.setCommunicationId(new Random().nextInt(5000));
		return dtoObj;
	}
	
	public Customer getCustomerFromPostCustomerDTO(CustomerSavePostDTO dto)
	{
		Customer c=new Customer();
		c.setCustomerName(dto.getCustomerName());
		c.setEmail(dto.getEmail());
		c.setPassword(dto.getPassword());
		return c;
	}

}