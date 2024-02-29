package com.example.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;

	public List<Order> getOrders() {
		return repository.findAll();
	}

}
