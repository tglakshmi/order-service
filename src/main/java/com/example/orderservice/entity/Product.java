package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="orderschema.product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column(name="Product_Name")
    private String productName;

    @Column(name="Product_Title")
    private String productTitle;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="orderdetails_id")
    private OrderDetails orderDetails;
}
