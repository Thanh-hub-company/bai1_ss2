package com.example.ecommerce.productservice.service;

import com.example.ecommerce.productservice.dto.response.ProductResponseDTO;
import java.util.List;

public interface ProductService {
    ProductResponseDTO getProductById(Long id);
    List<ProductResponseDTO> getAllProducts();
}