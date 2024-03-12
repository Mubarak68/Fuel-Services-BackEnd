package com.fuelservices.Fuel.and.Services.App.service.user;


import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UserRequestSubmission;
import com.fuelservices.Fuel.and.Services.App.entity.EndUserEntity;
import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;
import com.fuelservices.Fuel.and.Services.App.repository.EndUserRepository;
import com.fuelservices.Fuel.and.Services.App.repository.RequestRepository;
import com.fuelservices.Fuel.and.Services.App.repository.UserRepository;
import com.fuelservices.Fuel.and.Services.App.service.auth.UserDetailUtil;
import com.fuelservices.Fuel.and.Services.App.util.RequestType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RequestRepository requestRepository;

    private final EndUserRepository endUserRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RequestRepository requestRepository,
                           EndUserRepository endUserRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.requestRepository = requestRepository;
        this.endUserRepository = endUserRepository;
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
    public List<RequestEntity> getAllRequest() {
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
    public void submitRequest( Long service_Id) {
        UserEntity userEntity=userRepository.findById(UserDetailUtil.userDetails().getId())
                .orElseThrow();
        RequestEntity request = new RequestEntity();
        EndUserEntity endUserEntity = endUserRepository.findByUserEntity(userEntity);

        UserRequestSubmission userRequest = new UserRequestSubmission();
        userRequest.setRequestType(RequestType.waiting);
        userRequest.setServiceType(endUserEntity.getServiceType());
        userRequest.setCarType(endUserEntity.getCarType());
        userRequest.setLocation(endUserEntity.getLocation());

        requestRepository.save(request);

    }




}

