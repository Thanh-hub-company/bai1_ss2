package com.example.ecommerce.customerservice.service;

import com.example.ecommerce.customerservice.dto.request.CustomerRequestDTO;
import com.example.ecommerce.customerservice.dto.request.LoginRequestDTO;
import com.example.ecommerce.customerservice.dto.response.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO register(CustomerRequestDTO request);

    CustomerResponseDTO getCustomerById(Long id);

    CustomerResponseDTO login(LoginRequestDTO request);
}