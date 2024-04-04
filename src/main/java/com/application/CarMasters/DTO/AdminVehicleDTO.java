package com.application.CarMasters.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class AdminVehicleDTO {
    private Integer id;
    private String maker;
    private String model;
    private String vin;
    private Integer buyPrice;
    private Integer sellPrice;



}
