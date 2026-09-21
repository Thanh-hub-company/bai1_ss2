package com.example.ecommerce.orderservice.service;

import com.example.ecommerce.orderservice.dto.response.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProductById(Long id);
}