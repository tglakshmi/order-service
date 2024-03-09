package com.example.orderservice.dto;

import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OrderDetailsDto {


    private Long orderNumber;

    private Double price;

    private Integer quantity;

    private Integer discount;

    private Double total;

    private Double size;

    private String color;

    private LocalDate shipDate;

    private LocalDate billDate;

//    private List<Order> orders;
//
//    private List<Product> products;
}