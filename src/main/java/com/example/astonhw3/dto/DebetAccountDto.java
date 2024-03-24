package com.example.astonhw3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DebetAccountDto {

    private Long userId;

    private Integer balance;
}
