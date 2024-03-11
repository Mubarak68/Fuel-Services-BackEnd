package com.fuelservices.Fuel.and.Services.App.service.admin;


import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;

public interface AdminService {

    void updateStatusRequest(Long requestId, UpdateUserRequest updateStatusRequest);

}
