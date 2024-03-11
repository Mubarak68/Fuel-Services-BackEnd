package com.fuelservices.Fuel.and.Services.App.service.auth;


import com.fuelservices.Fuel.and.Services.App.bo.CustomUserDetails;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;
import com.fuelservices.Fuel.and.Services.App.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return buildCustomUserDetailsOfUsername(s);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private CustomUserDetails buildCustomUserDetailsOfUsername(String username) throws NotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow();
        if (userEntity == null){
            throw new NotFoundException("User not found");
        }
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setId(userEntity.getUser_Id());
        userDetails.setUserName(userEntity.getUsername());
        userDetails.setPassword(userEntity.getPassword());
      userDetails.setRole(userEntity.getRoles().getTitle().name());

        return userDetails;
    }
}