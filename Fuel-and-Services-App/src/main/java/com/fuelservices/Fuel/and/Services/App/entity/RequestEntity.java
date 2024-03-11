package com.fuelservices.Fuel.and.Services.App.entity;

import com.fuelservices.Fuel.and.Services.App.util.CarType;
import com.fuelservices.Fuel.and.Services.App.util.RequestType;

import javax.persistence.*;

@Entity
@Table(name = "request_entity")
public class RequestEntity {

    @Id
    @Column(name = "request_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long request_Id;

    @Enumerated(EnumType.STRING)
private CarType carType;
    @Enumerated(EnumType.STRING)
private RequestType requestType;

    @Column(name = "",nullable = false)
    private String location;

    @OneToOne
    @JoinColumn(name = "service_Id")
    private ServiceEntity serviceEntity;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "driver_Id")
    private DriverEntity driverEntity;
}
