package com.example.ecommerce.customerservice.service.impl;

import com.example.ecommerce.customerservice.dto.request.CustomerRequestDTO;
import com.example.ecommerce.customerservice.dto.request.LoginRequestDTO;
import com.example.ecommerce.customerservice.dto.response.CustomerResponseDTO;
import com.example.ecommerce.customerservice.entity.Customer;
import com.example.ecommerce.customerservice.exception.BadCredentialsException;
import com.example.ecommerce.customerservice.exception.ResourceNotFoundException;
import com.example.ecommerce.customerservice.repository.CustomerRepository;
import com.example.ecommerce.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // Tự động tạo constructor injection, giúp code ngắn gọn hơn
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional // Đảm bảo toàn vẹn dữ liệu khi ghi (write)
    public CustomerResponseDTO register(CustomerRequestDTO request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new BadCredentialsException("Email already exists");
        }

        Customer customer = Customer.builder()
                .username(request.getUsername())
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        return mapToResponseDTO(savedCustomer);
    }

    @Override
    @Transactional(readOnly = true) // Tối ưu hiệu năng khi chỉ đọc (read-only)
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        return mapToResponseDTO(customer);
    }

    @Override
    @Transactional(readOnly = true) // Tối ưu hiệu năng khi chỉ đọc (read-only)
    public CustomerResponseDTO login(LoginRequestDTO request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("email or password incorrect"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new BadCredentialsException("email or password incorrect");
        }

        return mapToResponseDTO(customer);
    }

    private CustomerResponseDTO mapToResponseDTO(Customer customer) {
        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .status(customer.getStatus())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}