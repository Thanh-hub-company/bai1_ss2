package com.example.ecommerce.orderservice.service.impl;

import com.example.ecommerce.orderservice.dto.response.ProductResponseDTO;
import com.example.ecommerce.orderservice.entity.ProductEntity;
import com.example.ecommerce.orderservice.repository.ProductRepository;
import com.example.ecommerce.orderservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        // Giả lập lấy dữ liệu từ DB (nếu chưa tạo bảng trong DB, trả về object mẫu để test)
        ProductEntity product = productRepository.findById(id)
                .orElseGet(() -> new ProductEntity(
                        id,
                        "Laptop Gaming Asus ROG",
                        "SKU-ROG-2024",
                        new BigDecimal("20000000"), // importPrice (Giá nhập - Sẽ bị ẩn)
                        new BigDecimal("28000000"), // sellPrice (Giá bán)
                        15                          // stockQuantity (Kho - Sẽ bị ẩn)
                ));

        // Map từ Entity sang DTO
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .sellPrice(product.getSellPrice())
                .build();
    }
}