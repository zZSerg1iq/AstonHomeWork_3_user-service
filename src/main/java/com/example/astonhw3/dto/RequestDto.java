package com.example.astonhw3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestDto {

    @Min(1)
    private final Long customerId;

    @NotBlank
    private final String password;

    @Email
    private final String email;

    @NotBlank
    private String operationType;

    private final Integer balance;

}
