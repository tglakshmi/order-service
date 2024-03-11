package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="orderschema.order")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="order_amount")
    private String orderAmount;

    @Column(name="Order_type")
    private String orderType;

    @Column(name="currency_code")
    private String currencyCode;

    @Column(name="ship_date")
    private LocalDate shipDate;

    @Column(name="sales_tax")
    private Integer salesTax;

    @Column(name="transaction_status")
    private String transactionStatus;

    @Column(name="err_msg")
    private String errMsg;

    @Column(name="payment_date")
    private LocalDate paymentDate;

    @Column(name="customerid")
    private Long customerID;

//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="orderdetails_id")
//    private OrderDetails orderDetails;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "order")
    private Set<Shipper> shippers;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "order")
    private Set<Payment> paymentList;
}
