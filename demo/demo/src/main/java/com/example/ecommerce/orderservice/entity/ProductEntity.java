package com.example.ecommerce.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private BigDecimal importPrice; // Thông tin nhạy cảm (Giá nhập)

    @Column(nullable = false)
    private BigDecimal sellPrice;   // Giá bán (Công khai)

    @Column(nullable = false)
    private Integer stockQuantity;  // Thông tin nội bộ (Số lượng tồn kho)
}