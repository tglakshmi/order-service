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
@Table(name= "order", schema = "web")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Column(name="Order_Date")
    private LocalDate orderDate;
    @Column(name="Order_Amount")
    private String orderAmount;
    @Column(name="Order_Type")
    private String orderType;
    @Column(name="Currency_Code")
    private String currencyCode;
    @Column(name="customerID")
    private String customerID;
    @OneToMany(cascade =CascadeType.ALL,mappedBy = "order")
    private List<Product> orderLineItem=new ArrayList<>();
}
