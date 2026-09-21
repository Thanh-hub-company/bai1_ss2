package com.example.ecommerce.productservice.service;

import com.example.ecommerce.productservice.dto.response.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProductDetail(Long id);
}
