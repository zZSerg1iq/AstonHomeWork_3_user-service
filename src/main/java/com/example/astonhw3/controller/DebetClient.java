package com.example.astonhw3.controller;


import com.example.astonhw3.dto.DebetAccountDto;
import lombok.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "debetClient", url = "http://localhost:8083/")
public interface DebetClient {
    @PostMapping("/api/v1/debet/create")
    ResponseEntity<Void> createDebetAccount(@RequestBody DebetAccountDto debetAccountDto);
    @PostMapping("/api/v1/debet/deposit")
    ResponseEntity<Void> depositToDebetAccount(@RequestBody DebetAccountDto debetAccountDto);
}
