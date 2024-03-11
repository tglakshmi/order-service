package com.example.orderservice.service;

import com.example.orderservice.dto.CustomerResponse;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.PaymentDto;
import com.example.orderservice.dto.ShipperDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.Shipper;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.repository.*;
import com.example.orderservice.transformer.OrderTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private RestTemplate restTemplate;
    @Autowired
    public OrderService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ShipperRepository shipperRepository;
   OrderTransformer orderTransformer;

    public List<OrderDto> getAllOrders()
    {
//      List<Order> orders=orderRepository.findAll();
//
//        return orders.stream().map(this::entityToDto).collect(Collectors.toList());
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderTransformer::mapToOrderDTO)
                .collect(Collectors.toList());

    }



//
public OrderDto createOrder(OrderDto orderDto) {
    Order dbOrder = OrderTransformer.mapToOrder(orderDto);
    System.out.println(dbOrder);
    Order updatedOrder =  orderRepository.save(dbOrder);
    OrderDto order = OrderTransformer.mapToOrderDTO(updatedOrder);
    return order;
}


    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
       this.findCustomer(order.getCustomerID());
        return OrderTransformer.mapToOrderDTO(order);
    }

    public OrderDto updateOrder(Long orderId, OrderDto updatedOrderDto) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));

        // Update the existing order entity with the data from the updatedOrderDto
//        existingOrder.setOrderDate(updatedOrderDto.getOrderDate());
//        existingOrder.setOrderAmount(updatedOrderDto.getOrderAmount());
//        existingOrder.setOrderType(updatedOrderDto.getOrderType());
        Order dborder=OrderTransformer.mapToOrder(updatedOrderDto);
        // Update other fields as needed

        // Save the updated order entity
        Order updatedOrder = orderRepository.save(dborder);
        dborder.setId(existingOrder.getId());
        return OrderTransformer.mapToOrderDTO(updatedOrder);
    }

    public void deleteOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        orderRepository.delete(order);
    }
    public void findCustomer(Long id)
    {
//        System.out.println(id);
//      String url="http://localhost:8081/api/customer/";
//      ResponseEntity<CustomerResponse[]> obj= restTemplate.getForEntity(url,CustomerResponse[].class);
//        CustomerResponse[] cust= obj.getBody();
//        Arrays.stream(cust).forEach(System.out::println);
        String url = "http://localhost:8081/api/customer/" + id;
        ResponseEntity<CustomerResponse> responseEntity = restTemplate.getForEntity(url, CustomerResponse.class);
        CustomerResponse customer = responseEntity.getBody();

        if (customer != null) {
            System.out.println("Customer found:");
            System.out.println(customer);
        } else {
            System.out.println("Customer not found for ID: " + id);
        }
    }
}
