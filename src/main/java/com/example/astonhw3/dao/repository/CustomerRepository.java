package com.example.astonhw3.dao.repository;

import com.example.astonhw3.dao.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
