package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="orderschema.order")
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
    private String customerID;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="orderdetails_id")
    private OrderDetails orderDetails;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "order")
    private List<Shipper> shippers=new ArrayList<>();

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "order")
    private List<Payment> paymentList=new ArrayList<>();
}
