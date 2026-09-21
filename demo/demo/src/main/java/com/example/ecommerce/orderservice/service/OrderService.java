package com.example.ecommerce.orderservice.service;

import com.example.ecommerce.orderservice.dto.response.OrderResponse;

public interface OrderService {
    String getHealthStatus();
    OrderResponse getOrderById(Long id);
}
