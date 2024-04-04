package com.application.CarMasters.controllers;

import com.application.CarMasters.DTO.AdminVehicleDTO;
import com.application.CarMasters.DTO.CustomerVehicleDTO;
import com.application.CarMasters.entity.Vehicle;
import com.application.CarMasters.services.AdminVehicleService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminVehicleController {

    @Autowired
    private AdminVehicleService vehicleService;




    @GetMapping("/admin/vehicles")
    public ResponseEntity<List<AdminVehicleDTO>> getAllVehicles() {
        List<AdminVehicleDTO> vehicleDTOS = vehicleService.getAllVehiclesFromStorage();
        if (vehicleDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(vehicleDTOS,HttpStatus.OK);
        }
    }

    @PostMapping("/admin/vehicles")
    public ResponseEntity<HttpStatus> addNewVehicleToStore(@RequestBody AdminVehicleDTO adminVehicleDTO) {
        vehicleService.addNewVehicleToStore(adminVehicleDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin/vehicles/{id}")
    public ResponseEntity<HttpStatus> updateVehicleParams(@PathVariable Integer id,@RequestBody AdminVehicleDTO adminVehicleDTO) {
        vehicleService.updateVehicleParams(id,adminVehicleDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("admin/vehicles/{id}")
    public ResponseEntity<HttpStatus> deleteVehicleById(@PathVariable Integer id) {
        vehicleService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("admin/vehicles")
    public ResponseEntity<HttpStatus> deleteAll() {
        vehicleService.deleteAllVehicles();
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
