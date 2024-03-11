package com.fuelservices.Fuel.and.Services.App.controller;

import com.fuelservices.Fuel.and.Services.App.bo.AuthinticationResponse;
import com.fuelservices.Fuel.and.Services.App.bo.CreateSignInRequest;
import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;
import com.fuelservices.Fuel.and.Services.App.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody CreateSignUpRequest createSignupRequest){
        authService.signup(createSignupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthinticationResponse> signin(@RequestBody CreateSignInRequest createSignInRequest){
        AuthinticationResponse response=authService.signin(createSignInRequest);
        HttpStatus status= HttpStatus.OK;
        if (response == null){
            status= HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, status);
    }

//    @PostMapping("/logout")
//    public ResponseEntity<Void> logout(@RequestBody LogoutResponse logoutResponse){
//        authService.logout(logoutResponse);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}