package com.cg.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.Orders;
import com.cg.bookstore.service.IOrdersService;

@RestController
@RequestMapping("/app")
public class OrdersRestController {
	
	@Autowired
	IOrdersService orderService;
	
	@PostMapping("/order")
	public boolean addOrder(@RequestBody Orders o)
	{
		orderService.addOrder(o);
		return true;
	}
	
	@GetMapping("/order/{orderId}")
	public Orders getOrderId(@PathVariable int orderId)
	{
		return orderService.getOrderById(orderId);
	}
	
	@GetMapping("/orders")
	public List<Orders> OrdersList()
	{
		return orderService.getAllOrders();
	}
	
	@DeleteMapping("/order/{orderId}")
	public boolean deleteOrder(@PathVariable int orderId)
	{
		return orderService.deleteOrderById(orderId);
	}
}
