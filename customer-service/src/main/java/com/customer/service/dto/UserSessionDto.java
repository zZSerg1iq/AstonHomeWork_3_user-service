package com.customer.service.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@Builder
public class UserSessionDto {

    private AccountDto accountId;

    private String authId;
}
