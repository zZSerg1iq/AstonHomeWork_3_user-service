package com.example.astonhw3.dao.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;

    private String password;

    private String mobilePhone;
}
