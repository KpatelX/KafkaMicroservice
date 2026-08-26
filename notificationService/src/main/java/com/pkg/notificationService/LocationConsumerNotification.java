package com.pkg.notificationService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.pkg.commonService.constants.ServiceConstants.KAFKA_CONSTANTS;
import static com.pkg.commonService.constants.ServiceConstants.USER_GROUP_ID;

@Service
public class LocationConsumerNotification {
    @KafkaListener(topics = KAFKA_CONSTANTS, groupId = USER_GROUP_ID)
    public void consumeLocation(String message) {
        System.out.println("User received location update: " + message);
    }
}
