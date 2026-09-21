package com.example.ecommerce.productservice.service.impl;

import com.example.ecommerce.orderservice.exception.ResourceNotFoundException;
import com.example.ecommerce.productservice.dto.response.ProductResponseDTO;
import com.example.ecommerce.productservice.entity.ProductEntity;
import com.example.ecommerce.productservice.mapper.ProductMapper;
import com.example.ecommerce.productservice.repository.ProductRepository;
import com.example.ecommerce.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        return ProductMapper.toResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}