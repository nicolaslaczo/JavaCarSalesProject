package com.application.CarMasters.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate localDate;
    private String maker;
    private String model;
    private String vin;
    private Integer buyPrice;
    private Integer sellPrice;









}
