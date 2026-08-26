package com.pkg.deliveryService.controller;

import com.pkg.deliveryService.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/updateLocation")
    public ResponseEntity<?> updateLocation(@RequestParam String deliveryBoyId, @RequestParam String location) {
        return deliveryService.updateLocation(deliveryBoyId, location);
    }
}