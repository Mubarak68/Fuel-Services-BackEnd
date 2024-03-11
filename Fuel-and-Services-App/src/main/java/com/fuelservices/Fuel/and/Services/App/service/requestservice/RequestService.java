package com.fuelservices.Fuel.and.Services.App.service.requestservice;

import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;

import java.util.List;

public interface RequestService {

    List<RequestEntity> getAllRequest();

    RequestEntity getRequestById(Long requestId);
}
