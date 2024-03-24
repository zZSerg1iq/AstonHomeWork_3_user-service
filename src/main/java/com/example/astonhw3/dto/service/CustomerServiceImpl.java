package com.example.astonhw3.dto.service;

import com.example.astonhw3.dao.entity.Customer;
import com.example.astonhw3.dao.repository.CustomerRepository;
import com.example.astonhw3.dto.RequestDto;
import com.example.astonhw3.dto.CustomerDto;
import com.example.astonhw3.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerDto getUserData(RequestDto requestDto) {
        Optional<Customer> temp = repository.findById(requestDto.getCustomerId());
        if (temp.isEmpty()){
            throw new CustomerNotFoundException();
        }
        Customer customer = temp.get();

        CustomerDto customerDto = CustomerDto
                .builder()
                .userId(customer.getUserId())
                .email(customer.getEmail())
                .mobilePhone(customer.getMobilePhone())
                .password(customer.getPassword())
                .build();

        return customerDto;
    }

}
