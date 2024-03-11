package com.fuelservices.Fuel.and.Services.App.service.user;


import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.GetUserRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;
import com.fuelservices.Fuel.and.Services.App.repository.RequestRepository;
import com.fuelservices.Fuel.and.Services.App.repository.UserRepository;
import com.fuelservices.Fuel.and.Services.App.service.auth.UserDetailUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RequestRepository requestRepository;


    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RequestRepository requestRepository
    ) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.requestRepository = requestRepository;
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
    public void updateUser(UpdateUserRequest updateUserRequest, Long id) {
        UserEntity userEntity = userRepository.getById(id);
        userEntity.setUsername(updateUserRequest.getUsername());

        userEntity.setEmail(updateUserRequest.getEmail());

        userEntity.setPassword(bCryptPasswordEncoder.encode(updateUserRequest.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public void submitRequest(Long garageId) {
        UserEntity userEntity=userRepository.findById(UserDetailUtil.userDetails().getId())
                .orElseThrow();

        RequestEntity request= new RequestEntity();

        requestRepository.save(request);
    }

}

//    UserEntity userEntity = userRepository.getById(id);
//    GetUserRequest getUserRequest = new GetUserRequest();
//        getUserRequest.setUsername(userEntity.getUsername());
//                getUserRequest.setPassword(userEntity.getPassword());
//                getUserRequest.setEmail(userEntity.getEmail());
//                getUserRequest.setId(userEntity.getUser_Id());
//                return getUserRequest;