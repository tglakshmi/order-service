package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;

@RequestMapping
@RestController
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders = service.getOrders();
		return ResponseEntity.ok(orders);
	}
	
}
