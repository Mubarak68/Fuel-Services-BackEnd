package com.fuelservices.Fuel.and.Services.App.service.user;




import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.GetUserRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;

import java.util.List;

public interface UserService {

    void saveUser(CreateSignUpRequest createSignupRequest);



    void updateUser(UpdateUserRequest updateUserRequest, Long id);


    void submitRequest(Long garageId);


}
