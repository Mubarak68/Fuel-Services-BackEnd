package com.fuelservices.Fuel.and.Services.App.entity;


import javax.persistence.*;

@Entity
@Table(name = "driver_entity")
public class DriverEntity {

    @Id
    @Column(name = "driver_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_Id;
}
