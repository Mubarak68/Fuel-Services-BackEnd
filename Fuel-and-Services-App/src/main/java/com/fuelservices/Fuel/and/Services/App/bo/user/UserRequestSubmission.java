package com.fuelservices.Fuel.and.Services.App.bo.user;

import com.fuelservices.Fuel.and.Services.App.util.CarType;
import com.fuelservices.Fuel.and.Services.App.util.RequestType;
import com.fuelservices.Fuel.and.Services.App.util.ServiceType;

public class UserRequestSubmission {
private CarType carType;
private String location;
private RequestType requestType;
private ServiceType serviceType;

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
