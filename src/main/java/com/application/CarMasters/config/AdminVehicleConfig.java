package com.application.CarMasters.config;

import com.application.CarMasters.services.AdminVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AdminVehicleConfig {

    @Bean
    public AdminVehicleService adminVehicleService() {
        return new AdminVehicleService();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
