package com.customer.service.dto;

import com.customer.service.enums.AccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

    private AccountType accountType;
    private boolean isActive;

}
