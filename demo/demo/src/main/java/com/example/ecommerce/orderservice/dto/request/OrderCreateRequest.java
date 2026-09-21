package com.example.ecommerce.orderservice.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderCreateRequest {
    private String customerCode;
    private BigDecimal totalAmount;
}