package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.PaymentDto;
import com.example.orderservice.dto.ShipperDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.Shipper;
import com.example.orderservice.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;
    private OrderDetailsRepository orderDetailsRepository;
    private PaymentRepository paymentRepository;
    private ProductRepository productRepository;
    private ShipperRepository shipperRepository;
   

    public List<OrderDto> getAllOrders()
    {
      List<Order> orders=orderRepository.findAll();

        return orders.stream().map(this::mapToOrderResponse).collect(Collectors.toList());

    }

    private OrderDto mapToOrderResponse(Order order) {
        return OrderDto.builder().id(order.getId())
                .customerID(order.getCustomerID())
                .currencyCode(order.getCurrencyCode())
                .orderAmount(order.getOrderAmount())
                .orderDate(order.getOrderDate())
                .orderType(order.getOrderType())
                .transactionStatus(order.getTransactionStatus())
                .paymentList(mapToPaymentResponse(order.getPaymentList()))
                .shippers(mapToShipperResponse(order.getShippers()))
                        .build();
    }
    private List<PaymentDto> mapToPaymentResponse(List<Payment> paymentList) {
        return paymentList.stream().map(payment-> {
            PaymentDto dto = new PaymentDto();
            dto.setId(payment.getId());
            dto.setPaymentType(payment.getPaymentType());
            return dto;
        }).collect(Collectors.toList());

    }
    private List<ShipperDto> mapToShipperResponse(List<Shipper> shippers) {
        return shippers.stream().map(shipper -> {
            ShipperDto dto=new ShipperDto();
            dto.setId(shipper.getId());
            dto.setCompanyName(shipper.getCompanyName());
            return dto;
        }).collect(Collectors.toList());
    }


}
