package com.customer.service.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    @NotNull
    @Positive
    private long userId;

    @NotNull
    @Email
    private String email;

    @NotBlank
    private String password;

    @Pattern(regexp = "\\d{11}")
    private String mobilePhone;

    private AccountDto userAccount;

}
