package com.cg.bookstore.dto;

public class CustomerOwnerBasicInfoDTO {
	
	private int customerId;
	private String customerName;
	private String email;
	private String password;
	private int communicationId;
	public CustomerOwnerBasicInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public int getCommunicationId() {
		return communicationId;
	}
	public void setCommunicationId(int communicationId) {
		this.communicationId = communicationId;
	}
	
}
