package com.example.astonhw3.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    public static final String TOPIC = "user_service_debet";
    public static final String GROUP = "user_service";

    @KafkaListener(topics = TOPIC, groupId = GROUP)
    public void listen(String message) {
        System.out.println("listen сработал " + message);
    }
}