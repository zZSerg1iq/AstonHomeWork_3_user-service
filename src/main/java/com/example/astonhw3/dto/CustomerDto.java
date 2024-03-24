package com.example.astonhw3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

    private long userId;

    private String email;

    private String password;

    private String mobilePhone;


}
