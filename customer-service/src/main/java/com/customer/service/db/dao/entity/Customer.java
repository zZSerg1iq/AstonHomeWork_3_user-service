package com.customer.service.db.dao.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // неиспользуй в качестве ключей примитивы. null имеет свою роль в этом

    private String email;
    private String password;
    private String mobilePhone;

    @OneToOne(mappedBy = "customerId", fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private CustomerAccount userCustomerAccount;

    @OneToOne(mappedBy = "customerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CustomerSession customerSession;
}
