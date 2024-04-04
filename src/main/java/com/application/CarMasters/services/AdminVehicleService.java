package com.application.CarMasters.services;

import com.application.CarMasters.DTO.AdminVehicleDTO;
import com.application.CarMasters.DTO.CustomerVehicleDTO;
import com.application.CarMasters.entity.Vehicle;
import com.application.CarMasters.repository.AdminVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminVehicleService {

    @Autowired
    private AdminVehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper mapper;




    public void addNewVehicleToStore(AdminVehicleDTO adminVehicleDTO) {
        Vehicle vehicle = mapper.map(adminVehicleDTO, Vehicle.class);
        vehicle.setLocalDate(LocalDate.now());
        vehicleRepository.save(vehicle);
    }

    public AdminVehicleDTO getVehicleById(Integer id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        AdminVehicleDTO adminVehicleDTO = mapper.map(vehicle,AdminVehicleDTO.class);
        return adminVehicleDTO;
    }

    public List<AdminVehicleDTO> getAllVehiclesFromStorage() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehicle -> mapper.map(vehicle, AdminVehicleDTO.class))
                .collect(Collectors.toList());
    }

    public void updateVehicleParams(Integer id,AdminVehicleDTO adminVehicleDTO) {
        Vehicle vehicle = mapper.map(adminVehicleDTO, Vehicle.class);
        vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle with id " + id + " dont exists"));

        vehicle.setMaker(adminVehicleDTO.getMaker());
        vehicle.setModel(adminVehicleDTO.getModel());
        vehicle.setBuyPrice(adminVehicleDTO.getBuyPrice());
        vehicle.setSellPrice(adminVehicleDTO.getSellPrice());
        vehicle.setVin(adminVehicleDTO.getVin());

        vehicleRepository.save(vehicle);
    }

    public void deleteById(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle with id" + id + "doesnt exist"));
        vehicleRepository.deleteById(id);

    }

    public void deleteAllVehicles() {
        vehicleRepository.deleteAll();
    }




































}
