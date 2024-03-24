package com.example.astonhw3.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RequestDto {

    @Min(1)
    private final Long customerId;

    @NotBlank
    private String operationType;

    private final Integer balance;

}
