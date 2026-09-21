package com.example.ecommerce.orderservice.dto.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderResponse {
    private Long id;
    private String customerCode;
    private BigDecimal totalAmount;
    private String status;
}