package com.example.orderservice.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Long id;

    private String productName;

    private String productTitle;
}
