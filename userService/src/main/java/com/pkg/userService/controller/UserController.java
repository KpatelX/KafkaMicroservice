package com.pkg.userService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.pkg.commonService.constants.ServiceConstants.DELIVERY_GROUP_ID;
import static com.pkg.commonService.constants.ServiceConstants.KAFKA_CONSTANTS;

@RestController
@RequestMapping("/user")
public class UserController {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = KAFKA_CONSTANTS, groupId = DELIVERY_GROUP_ID)
    public void listen(String message) {
        messages.add(message);
        System.out.println("Received: " + message);
    }

    @GetMapping("/getDeliveryLocations")
    public ResponseEntity<List<String>> getLocations() {
        return ResponseEntity.ok(messages);
    }
}
