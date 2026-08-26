package com.pkg.deliveryService.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeliveryService {
    public ResponseEntity<?> updateLocation(String deliveryBoyId, String location);
}