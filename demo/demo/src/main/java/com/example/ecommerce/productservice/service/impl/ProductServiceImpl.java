package com.example.ecommerce.productservice.service.impl;

import com.example.ecommerce.productservice.dto.response.ProductResponseDTO;
import com.example.ecommerce.productservice.entity.ProductEntity;
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
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        return mapToDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProductResponseDTO mapToDTO(ProductEntity product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .sellPrice(product.getSellPrice())
                .build();
    }
}