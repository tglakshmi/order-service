package com.example.orderservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "lineitem", schema = "web")
public class LineItem {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    
    @Column(name="product_name")
    private String productName;
    
    @Column(name="product_desc")
    private String productDesc;
    
    @Column(name="lineitem_price")
    private Double lineItemPrice;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

}
