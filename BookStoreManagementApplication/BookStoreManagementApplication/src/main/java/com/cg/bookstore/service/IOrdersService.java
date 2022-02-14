package com.cg.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Orders;

@Service
public interface IOrdersService {
	
	public Orders addOrder(Orders order);
	public List<Orders> getAllOrders();
	public boolean deleteOrderById(int orderId);
	public Orders getOrderById(int orderId);
	

}
