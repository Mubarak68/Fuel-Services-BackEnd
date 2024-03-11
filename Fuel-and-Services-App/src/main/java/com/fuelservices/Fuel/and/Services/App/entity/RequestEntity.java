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

    @Column(name = "location",nullable = false)
    private String location;
    @Enumerated(EnumType.STRING)
private CarType carType;
    @Enumerated(EnumType.STRING)
private RequestType requestType;



    @OneToOne
    @JoinColumn(name = "service_Id")
    private ServiceEntity serviceEntity;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "driver_Id")
    private DriverEntity driverEntity;

    public Long getRequest_Id() {
        return request_Id;
    }

    public void setRequest_Id(Long request_Id) {
        this.request_Id = request_Id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public DriverEntity getDriverEntity() {
        return driverEntity;
    }

    public void setDriverEntity(DriverEntity driverEntity) {
        this.driverEntity = driverEntity;
    }
}
