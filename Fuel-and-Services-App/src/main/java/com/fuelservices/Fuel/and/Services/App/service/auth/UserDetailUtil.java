package com.fuelservices.Fuel.and.Services.App.service.auth;

import com.fuelservices.Fuel.and.Services.App.bo.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserDetailUtil {
    public static CustomUserDetails userDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (CustomUserDetails) authentication.getPrincipal();
    }
}
