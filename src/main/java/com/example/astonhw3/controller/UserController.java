package com.example.astonhw3.controller;

import com.example.astonhw3.controller.service.DebetService;
import com.example.astonhw3.dto.CustomerDto;
import com.example.astonhw3.dto.DebetAccountDto;
import com.example.astonhw3.dto.RequestDto;
import com.example.astonhw3.dto.service.CustomerService;
import com.example.astonhw3.kafka.KafkaProducer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@Tag(name = "Основной и единственный контроллер, который принимает сообщения от UI пользователя")
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
    @Operation(summary = "Verify", description = "Метод принимает данные пользователя, " +
            "проверяет по базе наличие пользователя и его пароль, " +
            "после чего отправляет REST запрос другому сервису")

    @ApiResponse(description = "Возвращает ответ от микросервиса, а так же коды 404 в случае если юзер не найден или 400 в случае, если пароль не верен")
    public ResponseEntity<String> userRequest(@RequestBody RequestDto requestDto) {
        log.info("запрос получен: "+requestDto);

        CustomerDto customerDto = customerService.getUserData(requestDto);
        log.info("пользователь успешно валидирован: "+customerDto);

        DebetAccountDto debetAccountDto = DebetAccountDto
                .builder()
                .userId(customerDto.getUserId())
                .balance(requestDto.getBalance())
                .build();

        Gson gson = new GsonBuilder().create();
        if (requestDto.getOperationType().equals("create")) {
            debetService.createDebetAccount(debetAccountDto);
            //  kafkaProducer.sendMessage("topic_ASTON", gson.toJson(debetAccountDto));
        } else {
            debetService.depositToDebetAccount(debetAccountDto);
            //  kafkaProducer.sendMessage("topic_ASTON", gson.toJson(debetAccountDto));
        }

        return ResponseEntity.ok("Ok");
    }
}
