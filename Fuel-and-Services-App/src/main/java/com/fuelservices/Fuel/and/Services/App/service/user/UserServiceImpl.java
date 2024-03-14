package com.fuelservices.Fuel.and.Services.App.service.user;


import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UserRequestSubmission;
import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import com.fuelservices.Fuel.and.Services.App.entity.ServiceEntity;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;
import com.fuelservices.Fuel.and.Services.App.repository.RequestRepository;
import com.fuelservices.Fuel.and.Services.App.repository.ServiceRepository;
import com.fuelservices.Fuel.and.Services.App.repository.UserRepository;
import com.fuelservices.Fuel.and.Services.App.service.auth.UserDetailUtil;
import com.fuelservices.Fuel.and.Services.App.util.CarType;
import com.fuelservices.Fuel.and.Services.App.util.RequestType;
import com.fuelservices.Fuel.and.Services.App.util.ServiceType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RequestRepository requestRepository;

    private final ServiceRepository serviceRepository;


    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RequestRepository requestRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.requestRepository = requestRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void saveUser(CreateSignUpRequest createSignupRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(createSignupRequest.getUsername());

        userEntity.setPassword(createSignupRequest.getPassword());
        userEntity.setEmail(createSignupRequest.getEmail());
        userRepository.save(userEntity);

    }

    @Override
    public List<RequestEntity> getAllRequest(Long user_Id) {
        return null;
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest, Long id) {
        UserEntity userEntity = userRepository.getById(id);
        userEntity.setUsername(updateUserRequest.getUsername());

        userEntity.setEmail(updateUserRequest.getEmail());

        userEntity.setPassword(bCryptPasswordEncoder.encode(updateUserRequest.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public void submitRequest(Long service_Id, UserRequestSubmission userRequestSubmission) {
        UserEntity userEntity = userRepository.findById(UserDetailUtil.userDetails().getId())
                .orElseThrow();
        ServiceEntity serviceEntity = serviceRepository.getById(service_Id);

        RequestEntity requestEntity = new RequestEntity();


        requestEntity.setServiceType(userRequestSubmission.getServiceType());
        requestEntity.setCarType(userRequestSubmission.getCarType());
        requestEntity.setLocation(userRequestSubmission.getLocation());
        requestEntity.setUserEntity(userEntity);
        requestEntity.setServiceEntity(serviceEntity);
        requestRepository.save(requestEntity);
    }




}

