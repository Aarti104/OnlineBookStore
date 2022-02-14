package com.cg.bookstore.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CustomerSavePostDTO {
	
	@NotNull(message="Name is empty")
	private String customerName;
	@Email(message = "Email should be valid")
	private String email;
	@NotNull(message="Password cannot be Left Blank")
	private String password;
	public CustomerSavePostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerSavePostDTO(@NotNull(message = "Name is empty") String customerName,
			@Email(message = "Email should be valid") String email,
			@NotNull(message = "Password cannot be Left Blank") String password) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.password = password;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
