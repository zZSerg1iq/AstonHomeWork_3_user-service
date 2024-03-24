package com.example.astonhw3.controller.service;

import com.example.astonhw3.controller.DebetClient;
import com.example.astonhw3.dto.DebetAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DebetService {

    private final DebetClient debetClient;

    @Autowired
    public DebetService(DebetClient debetClient) {
        this.debetClient = debetClient;
    }

    public void createDebetAccount(DebetAccountDto debetAccountDto) {
        debetClient.createDebetAccount(debetAccountDto);
    }

    public void depositToDebetAccount(DebetAccountDto debetAccountDto) {
        debetClient.depositToDebetAccount(debetAccountDto);
    }


}
