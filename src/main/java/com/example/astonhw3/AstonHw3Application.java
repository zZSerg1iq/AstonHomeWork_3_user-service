package com.example.astonhw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AstonHw3Application {

    public static void main(String[] args) {
        SpringApplication.run(AstonHw3Application.class, args);
    }

}
