package com.cg.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Orders;
import com.cg.bookstore.repository.IOrdersRepository;

@Service
public class OrdersServiceImpl implements IOrdersService {

	@Autowired
	IOrdersRepository orderRepo;
	
	@Override
	public Orders addOrder(Orders order) {
		return orderRepo.save(order) ;
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> list=(List<Orders>) orderRepo.findAll();
		return list;
	}

	@Override
	public boolean deleteOrderById(int orderId) {
		orderRepo.deleteById(orderId);
		return true;
	}

	@Override
	public Orders getOrderById(int orderId) {
		return orderRepo.findById(orderId).get();
	}

}
