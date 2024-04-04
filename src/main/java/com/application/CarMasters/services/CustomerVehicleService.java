package com.application.CarMasters.services;

import com.application.CarMasters.DTO.CustomerVehicleDTO;
import com.application.CarMasters.config.VehicleSpecification;
import com.application.CarMasters.entity.Vehicle;
import com.application.CarMasters.repository.AdminVehicleRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerVehicleService {
    @Autowired
    private AdminVehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper mapper;



    public List<CustomerVehicleDTO> findAllVehicles(String maker, String model, Integer sellPrice) {
        final Specification<Vehicle> specification = VehicleSpecification.filterVehicle(maker, model, sellPrice);
        final List<Vehicle> vehicles = vehicleRepository.findAll(specification);
        return vehicles.stream()
                .map(vehicle -> mapper.map(vehicle, CustomerVehicleDTO.class))
                .collect(Collectors.toList());
    }

    public List<CustomerVehicleDTO> searchVehicles(String search) {
        final Specification<Vehicle> specification = VehicleSpecification.searchVehicle(search);
        final List<Vehicle> vehicles = vehicleRepository.findAll(specification);
        return vehicles.stream()
                .map(vehicle -> mapper.map(vehicle, CustomerVehicleDTO.class))
                .collect(Collectors.toList());
    }





























}
