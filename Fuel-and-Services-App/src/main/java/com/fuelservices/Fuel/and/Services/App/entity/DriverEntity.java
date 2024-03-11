package com.fuelservices.Fuel.and.Services.App.entity;


import javax.persistence.*;

@Entity
@Table(name = "driver_entity")
public class DriverEntity {

    @Id
    @Column(name = "driver_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_Id;

    @Column(name = "plate_license",nullable = false)
    private String plate_license;

    public Long getDriver_Id() {
        return driver_Id;
    }

    public void setDriver_Id(Long driver_Id) {
        this.driver_Id = driver_Id;
    }

    public String getPlate_license() {
        return plate_license;
    }

    public void setPlate_license(String plate_license) {
        this.plate_license = plate_license;
    }
}
