package com.example.ecommerce.productservice.config;

import com.example.ecommerce.productservice.entity.ProductEntity;
import com.example.ecommerce.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductDataInitializer {

    @Bean
    CommandLineRunner seedProducts(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                productRepository.save(new ProductEntity(
                        null,
                        "Laptop Gaming",
                        "SKU-1001",
                        new BigDecimal("15000000"),
                        new BigDecimal("18990000"),
                        25
                ));
            }
        };
    }
}
