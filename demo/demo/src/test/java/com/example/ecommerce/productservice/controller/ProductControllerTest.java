package com.example.ecommerce.productservice.controller;

import com.example.ecommerce.productservice.dto.response.ProductResponseDTO;
import com.example.ecommerce.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getProductDetailReturnsOnlyPublicProductFields() throws Exception {
        when(productService.getProductById(1L))
                .thenReturn(new ProductResponseDTO(1L, "Laptop Gaming", new BigDecimal("18990000")));

        mockMvc.perform(get("/api/v1/products/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop Gaming"))
                .andExpect(jsonPath("$.sellPrice").value(18990000))
                .andExpect(jsonPath("$.sku").doesNotExist())
                .andExpect(jsonPath("$.importPrice").doesNotExist())
                .andExpect(jsonPath("$.stockQuantity").doesNotExist());
    }
}
