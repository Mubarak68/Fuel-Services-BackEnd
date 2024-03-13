package com.fuelservices.Fuel.and.Services.App.service.user;




import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.GetUserRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UserRequestSubmission;
import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;

import java.util.List;

public interface UserService {

    void saveUser(CreateSignUpRequest createSignupRequest);

    List<RequestEntity> getAllRequest();

    void updateUser(UpdateUserRequest updateUserRequest, Long user_Id);


    void submitRequest(Long service_Id, UserRequestSubmission userRequestSubmission);


}
