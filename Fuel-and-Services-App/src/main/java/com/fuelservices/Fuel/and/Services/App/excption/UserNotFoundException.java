package com.fuelservices.Fuel.and.Services.App.excption;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String str){
        super(str);
    }
}