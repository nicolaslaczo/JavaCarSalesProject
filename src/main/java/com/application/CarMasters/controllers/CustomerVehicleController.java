package com.application.CarMasters.controllers;

import com.application.CarMasters.DTO.CustomerVehicleDTO;
import com.application.CarMasters.services.CustomerVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class CustomerVehicleController {

    @Autowired
    private CustomerVehicleService vehicleService;


    @GetMapping("/home/vehicles")
    public ResponseEntity<List<CustomerVehicleDTO>> getVehicles(
            @RequestParam(required = false) String maker,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer sellPrice) {
        return ResponseEntity.ok(vehicleService.findAllVehicles(maker,model,sellPrice));
    }

    @GetMapping("/home/vehicles/search")
    public ResponseEntity<List<CustomerVehicleDTO>> searchVehicles(@RequestParam(required = false) String search) {
        return ResponseEntity.ok(vehicleService.searchVehicles(search));
    }





































}
