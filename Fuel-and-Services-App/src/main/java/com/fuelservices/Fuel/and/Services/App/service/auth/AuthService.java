package com.fuelservices.Fuel.and.Services.App.service.auth;



import com.fuelservices.Fuel.and.Services.App.bo.AuthinticationResponse;
import com.fuelservices.Fuel.and.Services.App.bo.CreateSignInRequest;
import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;

import javax.transaction.Transactional;

public interface AuthService {

    @Transactional
    void signup(CreateSignUpRequest createSignupRequest);

    AuthinticationResponse signin(CreateSignInRequest createLoginRequest);


}