package com.example.astonhw3.dto.service;

import com.example.astonhw3.dao.entity.Customer;
import com.example.astonhw3.dao.repository.CustomerRepository;
import com.example.astonhw3.dto.CustomerDto;
import com.example.astonhw3.dto.RequestDto;
import com.example.astonhw3.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerDto getUserData(RequestDto requestDto) {

        Optional<Customer> temp = repository.findById(requestDto.getCustomerId());
        if (temp.isEmpty()) {
            log.warn("Ошибка получения пользователя по переданному ID : " + requestDto.getCustomerId() + " - пользователь не существует");
            throw new CustomerNotFoundException();
        }
        Customer customer = temp.get();

        if (!customer.getEmail().equals(requestDto.getEmail()) || !customer.getPassword().equals(requestDto.getPassword())) {
            log.warn("Ошибка валидации: запрос содержит некорректный EMail или пароль: " + requestDto);
            throw new IncorrectValidationData();
        }

        return CustomerDto
                .builder()
                .userId(customer.getUserId())
                .email(customer.getEmail())
                .mobilePhone(customer.getMobilePhone())
                .password(customer.getPassword())
                .build();
    }

}
