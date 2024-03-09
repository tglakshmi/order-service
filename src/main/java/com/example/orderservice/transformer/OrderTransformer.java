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
        dborder.setPaymentList(mapToPayment(order.getPaymentList()));
        dborder.setShippers(mapToShipper(order.getShippers()));
        return dborder;
    }

    private static Set<Shipper> mapToShipper(Set<ShipperDto> shippers) {
        if(shippers==null)
        {
            return new HashSet<>();
        }
        Set<Shipper> dbShippers = new HashSet<>();
        for(ShipperDto shipperDto:shippers){
            Shipper shipper = new Shipper();
            shipper.setCompanyName(shipperDto.getCompanyName());
            dbShippers.add(shipper);
        }
        return dbShippers;

    }
    private static Set<Payment> mapToPayment(Set<PaymentDto> paymentType) {
        if(paymentType==null)
        {
            return new HashSet<>();
        }
        Set<Payment> dbPayments=new HashSet<>();
        for(PaymentDto paymentDto:paymentType)
        {
            Payment payment=new Payment();
            payment.setPaymentType(paymentDto.getPaymentType());
            dbPayments.add(payment);
        }
        return dbPayments;

    }
    public static OrderDto mapToOrderDTO(Order updatedOrder) {
        OrderDto orderDto=new OrderDto();
        orderDto.setOrderDate(updatedOrder.getOrderDate());
        orderDto.setOrderAmount(updatedOrder.getOrderAmount());
        orderDto.setOrderType(updatedOrder.getOrderType());
        orderDto.setPaymentList(mapToPaymentDto(updatedOrder.getPaymentList()));
        orderDto.setShippers(mapToShipperDto(updatedOrder.getShippers()));
        return orderDto;
    }

    private static Set<ShipperDto> mapToShipperDto(Set<Shipper> shippers) {
        if(shippers==null)
        {
            return new HashSet<>();
        }
        Set<ShipperDto> shipperDtos = new HashSet<>();
        for(Shipper shipper:shippers) {
            ShipperDto shipperDto = new ShipperDto();
            shipperDto.setCompanyName(shipper.getCompanyName());
            shipperDtos.add(shipperDto);
        }
        return shipperDtos;
    }

    private static Set<PaymentDto> mapToPaymentDto(Set<Payment> paymentList) {
        if(paymentList==null)
        {
            return new HashSet<>();
        }
        Set<PaymentDto> paymentDto=new HashSet<>();
        for(Payment payment:paymentList){
            PaymentDto paymentDt=new PaymentDto();
            paymentDt.setPaymentType(payment.getPaymentType());
            paymentDto.add(paymentDt);
        }
        return paymentDto;
    }
}
