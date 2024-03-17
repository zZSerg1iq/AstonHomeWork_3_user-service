package com.customer.service.db.dao.entity;

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

    @OneToOne(mappedBy = "customerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CustomerAccount userCustomerAccount;

    @OneToOne(mappedBy = "customerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CustomerSession customerSession;

    
}
