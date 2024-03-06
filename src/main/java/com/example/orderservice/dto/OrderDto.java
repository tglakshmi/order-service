package com.example.orderservice.dto;

import com.example.orderservice.entity.OrderDetails;
import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.Shipper;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private Long id;

    private LocalDate orderDate;

    private String orderAmount;

    private String orderType;

    private String currencyCode;

    private LocalDate shipDate;

    private Integer salesTax;

    private String transactionStatus;

    private String errMsg;

    private LocalDate paymentDate;

    private String customerID;

    private List<Shipper> shippers;

    private List<Payment> paymentList;
}
