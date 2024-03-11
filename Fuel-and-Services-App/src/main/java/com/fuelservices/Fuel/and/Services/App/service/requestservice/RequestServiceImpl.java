package com.fuelservices.Fuel.and.Services.App.service.requestservice;

import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import com.fuelservices.Fuel.and.Services.App.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RequestServiceImpl implements RequestService{

    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<RequestEntity> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public RequestEntity getRequestById(Long request_Id) {
        return requestRepository.findById(request_Id)
                .orElseThrow();
    }
}
