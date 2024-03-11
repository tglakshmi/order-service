package com.example.orderservice.transformer;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.PaymentDto;
import com.example.orderservice.dto.ShipperDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.Shipper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderTransformer {


    public static Order mapToOrder(OrderDto order) {
        Order dborder=new Order();
        dborder.setOrderDate(order.getOrderDate());
        dborder.setOrderAmount(order.getOrderAmount());
        dborder.setOrderType(order.getOrderType());
        dborder.setCustomerID(order.getCustomerID());
        dborder.setPaymentList(mapToPayment(order.getPaymentList(),dborder));
        dborder.setShippers(mapToShipper(order.getShippers(),dborder));
        return dborder;
    }

    private static Set<Shipper> mapToShipper(Set<ShipperDto> shippers,Order order) {
//        if(shippers==null)
//        {
//            return new HashSet<>();
//        }

        Set<Shipper> dbShippers = new HashSet<>();
        for(ShipperDto shipperDto:shippers){
            Shipper shipper = new Shipper();
            shipper.setCompanyName(shipperDto.getCompanyName());
           shipper.setOrder(order);
            dbShippers.add(shipper);
        }
        return dbShippers;

//        return shippers.stream().map(shipperCompany->{
//            Order order=new Order();
//            Shipper shipper=new Shipper();
//            shipper.setCompanyName(shipperCompany.getCompanyName());
//            shipper.setOrder(order);
//            return shipper;
//        }).collect(Collectors.toSet());

    }
    private static Set<Payment> mapToPayment(Set<PaymentDto> paymentList,Order order) {
//        if(paymentType==null)
//        {
//            return new HashSet<>();
//        }
//
        Set<Payment> dbPayment=new HashSet<>();
        for(PaymentDto paymentDto:paymentList)
        {
            Payment payment=new Payment();
            payment.setPaymentType(paymentDto.getPaymentType());
            payment.setOrder(order);
            dbPayment.add(payment);
        }
        return dbPayment;

//        return paymentList.stream().map(paymentMethod ->
//        {
//
//            Payment payment=new Payment();
//            payment.setPaymentType(paymentMethod.getPaymentType());
//            payment.setOrder(order);
//            return payment;
//        }).collect(Collectors.toSet());

    }
    public static OrderDto mapToOrderDTO(Order updatedOrder) {
        OrderDto orderDto=new OrderDto();
        orderDto.setOrderDate(updatedOrder.getOrderDate());
        orderDto.setOrderAmount(updatedOrder.getOrderAmount());
        orderDto.setOrderType(updatedOrder.getOrderType());
        orderDto.setCustomerID(updatedOrder.getCustomerID());
        orderDto.setPaymentList(mapToPaymentDto(updatedOrder.getPaymentList()));
        orderDto.setShippers(mapToShipperDto(updatedOrder.getShippers()));
        return orderDto;
    }

    private static Set<ShipperDto> mapToShipperDto(Set<Shipper> shippers) {
//        if(shippers==null)
//        {
//            return new HashSet<>();
//        }
//        Set<ShipperDto> shipperDtos = new HashSet<>();
//        for(Shipper shipper:shippers) {
//            ShipperDto shipperDto = new ShipperDto();
//            shipperDto.setCompanyName(shipper.getCompanyName());
//            shipperDtos.add(shipperDto);
//        }
//        return shipperDtos;
        return shippers.stream().map(shipperCompany->{
            ShipperDto dto=new ShipperDto();
            dto.setCompanyName(shipperCompany.getCompanyName());

            return dto;
                }).collect(Collectors.toSet());

    }

    private static Set<PaymentDto> mapToPaymentDto(Set<Payment> paymentList) {
//        if(paymentList==null)
//        {
//            return new HashSet<>();
//        }
//        Set<PaymentDto> paymentDto=new HashSet<>();
//        for(Payment payment:paymentList){
//            PaymentDto paymentDt=new PaymentDto();
//            paymentDt.setPaymentType(payment.getPaymentType());
//            paymentDto.add(paymentDt);
//        }
//        return paymentDto;
        return paymentList.stream().map(paymentMethod->{
            PaymentDto dto=new PaymentDto();
            dto.setPaymentType(paymentMethod.getPaymentType());
            return dto;
        }) .collect(Collectors.toSet());
    }
}
