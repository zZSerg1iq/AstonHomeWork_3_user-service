package com.example.astonhw3.controller;

import com.example.astonhw3.controller.service.DebetService;
import com.example.astonhw3.dto.CustomerDto;
import com.example.astonhw3.dto.DebetAccountDto;
import com.example.astonhw3.dto.RequestDto;
import com.example.astonhw3.dto.service.CustomerService;
import com.example.astonhw3.kafka.KafkaConsumer;
import com.example.astonhw3.kafka.KafkaProducer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final DebetService debetService;
    private final CustomerService customerService;

    private final KafkaProducer kafkaProducer;

    @Autowired
    public UserController(DebetService debetService, CustomerService customerService, KafkaProducer kafkaProducer) {
        this.debetService = debetService;
        this.customerService = customerService;
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public ResponseEntity<String> userRequest(@RequestBody RequestDto requestDto) {
        CustomerDto customerDto = customerService.getUserData(requestDto);
        System.out.println(customerDto);


        DebetAccountDto debetAccountDto = DebetAccountDto
                .builder()
                .userId(customerDto.getUserId())
                .balance(requestDto.getBalance())
                .build();

      Gson gson = new GsonBuilder().create();

/*
        if (requestDto.getOperationType().equals("create")) {
            debetService.createDebetAccount(debetAccountDto);
            kafkaProducer.sendMessage("topic_ASTON", debetAccountDto);
        } else {
            debetService.depositToDebetAccount(debetAccountDto);
            kafkaProducer.sendMessage("topic_ASTON", debetAccountDto);
        }*/


        kafkaProducer.sendMessage("topic_ASTON", gson.toJson(debetAccountDto));

        return ResponseEntity.ok("Ok");
    }
}
