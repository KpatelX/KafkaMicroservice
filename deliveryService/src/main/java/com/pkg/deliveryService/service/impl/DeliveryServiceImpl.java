package com.pkg.deliveryService.service.impl;

import com.pkg.deliveryService.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.pkg.commonService.constants.ServiceConstants.KAFKA_CONSTANTS;


@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public DeliveryServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public ResponseEntity<?> updateLocation(String deliveryBoyId, String location) {
        String message = "{ \"deliveryBoyId\":\"" + deliveryBoyId + "\", \"location\":\"" + location + "\", \"timestamp\":\"" + java.time.Instant.now() + "\" }";
        kafkaTemplate.send(KAFKA_CONSTANTS, message);
        return ResponseEntity.ok(Map.of("status", "Location update sent"));
    }

}
