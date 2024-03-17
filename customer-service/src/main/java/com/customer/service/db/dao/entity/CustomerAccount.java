package com.customer.service.db.dao.entity;

import com.customer.service.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // зачем sequence нужен был? Под него надо ручками sequence делать
    private Long id; // неиспользуй в качестве ключей примитивы. null имеет свою роль в этом

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private boolean isActive;

    @OneToOne
    @PrimaryKeyJoinColumn // joinColumn по primary keys
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
