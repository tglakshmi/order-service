package com.example.orderservice.transformer;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.PaymentDto;
import com.example.orderservice.dto.ShipperDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.Shipper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderTransformer {
    public OrderDto mapToOrder(Order order) {
        Order dborder=new Order();
        dborder.setId(order.getId());
        dborder.setOrderDate(order.getOrderDate());
        dborder.setOrderAmount(order.getOrderAmount());
        dborder.setOrderType(order.getOrderType());
        dborder.setPaymentList(mapToPayment(order.getPaymentList()));
        dborder.setShippers(mapToShipper(order.getShippers()));
        return orderDTO;
    }
    private List<Shipper> mapToShipper(List<ShipperDto> shippers) {
        Shipper dbshipper=new Shipper();
        dbshipper.setCompanyName(shippers.getCompanyName());
        return dbshipper;

    }
    private List<Payment> mapToPayment(List<PaymentDto> paymentType) {
        Payment dbpayment=new Payment();
        dbpayment.setPaymentType(paymentType.getPaymentType());
        return dbpayment;
    }
}
