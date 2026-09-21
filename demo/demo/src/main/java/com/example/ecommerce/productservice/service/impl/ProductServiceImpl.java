package com.example.ecommerce.productservice.service.impl;

import com.example.ecommerce.productservice.dto.response.ProductResponseDTO;
import com.example.ecommerce.productservice.entity.ProductEntity;
import com.example.ecommerce.productservice.mapper.ProductMapper;
import com.example.ecommerce.productservice.repository.ProductRepository;
import com.example.ecommerce.productservice.service.ProductService;
import com.example.ecommerce.orderservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO getProductDetail(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sản phẩm với id: " + id));
        return ProductMapper.toResponseDTO(productEntity);
    }
}
