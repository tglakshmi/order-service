package com.example.orderservice.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "order", schema = "web")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
   
    @Column(name="order_date")
    private LocalDate orderDate;
    
    @Column(name="order_amount")
    private Double orderAmount;
    
    @Column(name="order_type")
    private OrderType orderType;
    
    @Column(name="currency_code")
    private String currencyCode;
    
    @Column(name="customer_iD")
    private Long customerId;
    
    @OneToMany(cascade =CascadeType.ALL, mappedBy = "order")
    private Set<LineItem> lineItems = new HashSet<>();
}
