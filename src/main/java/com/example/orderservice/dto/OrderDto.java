package com.example.orderservice.dto;

import com.example.orderservice.entity.OrderDetails;
import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.Shipper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    private LocalDate orderDate;

    private String orderAmount;

    private String orderType;

    private String currencyCode;

    private Integer salesTax;

    private String transactionStatus;

    private String errMsg;

    private LocalDate paymentDate;

    private String customerID;

    private Set<ShipperDto> shippers;

    private Set<PaymentDto> paymentList;
}
