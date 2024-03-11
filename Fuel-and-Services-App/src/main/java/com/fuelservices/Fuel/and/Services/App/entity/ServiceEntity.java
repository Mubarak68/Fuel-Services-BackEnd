package com.fuelservices.Fuel.and.Services.App.entity;



//Double	price

import com.fuelservices.Fuel.and.Services.App.util.Roles;
import com.fuelservices.Fuel.and.Services.App.util.ServiceType;

import javax.persistence.*;

@Entity
@Table(name = "service_entity")
public class ServiceEntity {
    @Id
    @Column(name = "service_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_Id;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(name = "price", nullable = false)
    private Double price;

    public Long getService_Id() {
        return service_Id;
    }

    public void setService_Id(Long service_Id) {
        this.service_Id = service_Id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
