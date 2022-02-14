package com.cg.bookstore.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

	@Id
	@SequenceGenerator(name="mycustlogic",initialValue=1200,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mycustlogic")
	private int customerId;
	@Email(message = "Email should be valid")
	private String email;
	@NotNull(message="Customer Name Cannot be Left Blank")
	private String customerName;
	@NotNull(message="Password cannot be Left Blank")
	private String password;
	@Embedded
	private Address address;
	private String mobileNumber;
	private LocalDate registerOn;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Customer_Order_Info",
			joinColumns=@JoinColumn(name="customerdetails"),
			inverseJoinColumns=@JoinColumn(name="orderdetails"))
	private List<Orders> order;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Customer_Book_Info",
			joinColumns=@JoinColumn(name="customerdetails"),
			inverseJoinColumns=@JoinColumn(name="bookdetails"))
	private List<Book> books;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int customerId, @Email(message = "Email should be valid") String email,
			@NotNull(message = "Customer Name Cannot be Left Blank") String customerName,
			@NotNull(message = "Password cannot be Left Blank") String password, Address address, String mobileNumber,
			LocalDate registerOn, List<Orders> order, List<Book> books) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.customerName = customerName;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.registerOn = registerOn;
		this.order = order;
		this.books = books;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public LocalDate getRegisterOn() {
		return registerOn;
	}
	public void setRegisterOn(LocalDate registerOn) {
		this.registerOn = registerOn;
	}
	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registerOn == null) ? 0 : registerOn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registerOn == null) {
			if (other.registerOn != null)
				return false;
		} else if (!registerOn.equals(other.registerOn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", email=" + email + ", customerName=" + customerName
				+ ", password=" + password + ", address=" + address + ", mobileNumber=" + mobileNumber + ", registerOn="
				+ registerOn + ", order=" + order + ", books=" + books + "]";
	}

	
	
	
}
