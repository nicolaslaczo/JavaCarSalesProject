package com.application.CarMasters.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerVehicleDTO {
    private Integer id;
    private String maker;
    private String model;
    private Integer sellPrice;
}
