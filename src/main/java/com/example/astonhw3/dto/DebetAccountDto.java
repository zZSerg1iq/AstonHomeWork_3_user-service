package com.example.astonhw3.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class DebetAccountDto {

    private Long userId;

    private Integer balance;
}
