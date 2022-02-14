package com.cg.bookstore.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Orders {
	@Id
	@SequenceGenerator(name="myorderslogic",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="myorderslogic")
	private int orderId;
	private boolean orderStatus;
	private LocalDate orderDate;
	private double totalPrice;
	

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Customer_Order_Info",
			joinColumns=@JoinColumn(name="orderdetails"),
			inverseJoinColumns=@JoinColumn(name="customerdetails"))
	private List<Customer> customers;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Orders(int orderId, boolean orderStatus, LocalDate orderDate, double totalPrice, List<Customer> customers) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.customers = customers;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderId;
		result = prime * result + (orderStatus ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Orders))
			return false;
		Orders other = (Orders) obj;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", totalPrice=" + totalPrice +  "]";
	}

	
	
	
}
