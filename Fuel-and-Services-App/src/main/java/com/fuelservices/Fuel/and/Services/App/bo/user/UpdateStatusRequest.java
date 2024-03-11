package com.fuelservices.Fuel.and.Services.App.bo.user;

public class UpdateStatusRequest {

    private String requestType;

    public String getRequestStatus() {
        return requestType;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestType = requestType;
    }
}
