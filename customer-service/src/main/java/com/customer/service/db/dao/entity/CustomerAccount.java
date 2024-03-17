package com.customer.service.db.dao.entity;

import com.customer.service.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private AccountType accountType;
    private boolean isActive;

    @OneToOne
    @JoinColumn
    private Customer customerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAccount customerAccount = (CustomerAccount) o;
        return isActive == customerAccount.isActive && accountType == customerAccount.accountType && customerId.equals(customerAccount.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, isActive, customerId);
    }
}
