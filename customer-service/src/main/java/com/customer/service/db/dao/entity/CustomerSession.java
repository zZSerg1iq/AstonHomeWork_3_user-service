package com.customer.service.db.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class CustomerSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customerId;

    private String authId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSession that = (CustomerSession) o;
        return customerId.equals(that.customerId) && authId.equals(that.authId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, authId);
    }
}
