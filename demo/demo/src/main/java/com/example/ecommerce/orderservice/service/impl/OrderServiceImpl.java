package com.example.ecommerce.orderservice.service.impl;

import com.example.ecommerce.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String getHealthStatus() {
        return "Order Service is UP";
    }
}
