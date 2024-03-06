package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="orderschema.orderdetail")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column(name="order_number")
    private Long orderNumber;

    @Column(name="price")
    private Double price;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="discount")
    private Integer discount;

    @Column(name="total_amount")
    private Double total;

    @Column(name="size")
    private Double size;

    @Column(name="color")
    private String color;

    @Column(name="ship_date")
    private LocalDate shipDate;

    @Column(name="bill_date")
    private LocalDate billDate;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "orderDetails")
    private List<Order> orders=new ArrayList<>();

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "orderDetails")
    private List<Product> products=new ArrayList<>();
}