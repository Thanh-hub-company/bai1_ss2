package com.example.ecommerce.productservice.mapper;

import com.example.ecommerce.productservice.dto.response.ProductResponseDTO;
import com.example.ecommerce.productservice.entity.ProductEntity;

public final class ProductMapper {

    private ProductMapper() {
    }

    public static ProductResponseDTO toResponseDTO(ProductEntity productEntity) {
        return new ProductResponseDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getSellPrice()
        );
    }
}
