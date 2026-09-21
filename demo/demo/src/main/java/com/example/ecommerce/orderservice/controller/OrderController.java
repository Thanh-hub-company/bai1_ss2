package com.example.ecommerce.orderservice.controller;

import com.example.ecommerce.orderservice.dto.response.OrderResponse;
import com.example.ecommerce.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // API Health Check (Từ Bài 1)
    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok(orderService.getHealthStatus());
    }

    // API Lấy Order theo ID - Dùng để test Bài 4 (Custom Exception)
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}