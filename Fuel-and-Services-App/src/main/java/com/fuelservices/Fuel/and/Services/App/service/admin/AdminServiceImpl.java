package com.fuelservices.Fuel.and.Services.App.service.admin;


import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import com.fuelservices.Fuel.and.Services.App.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private final RequestRepository requestRepository;

    public AdminServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }


    @Override
    public void updateStatusRequest(Long request_Id, UpdateUserRequest updateStatusRequest) {
        RequestEntity request = requestRepository.findById(request_Id).orElseThrow();
        requestRepository.save(request);
    }
}
