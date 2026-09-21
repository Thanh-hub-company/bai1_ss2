package com.example.ecommerce.orderservice.service.impl;

import com.example.ecommerce.orderservice.dto.response.OrderResponse;
import com.example.ecommerce.orderservice.entity.Order;
import com.example.ecommerce.orderservice.exception.ResourceNotFoundException;
import com.example.ecommerce.orderservice.repository.OrderRepository;
import com.example.ecommerce.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String getHealthStatus() {
        return "Order service is healthy";
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setCustomerCode(order.getCustomerCode());
        response.setTotalAmount(order.getTotalAmount());
        response.setStatus(order.getStatus());
        return response;
    }
}