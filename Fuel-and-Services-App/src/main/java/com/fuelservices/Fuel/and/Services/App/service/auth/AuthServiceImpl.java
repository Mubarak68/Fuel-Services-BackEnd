package com.fuelservices.Fuel.and.Services.App.service.auth;

import com.fuelservices.Fuel.and.Services.App.bo.AuthinticationResponse;
import com.fuelservices.Fuel.and.Services.App.bo.CreateSignInRequest;
import com.fuelservices.Fuel.and.Services.App.bo.CreateSignUpRequest;
import com.fuelservices.Fuel.and.Services.App.bo.CustomUserDetails;
import com.fuelservices.Fuel.and.Services.App.config.JWTUtil;
import com.fuelservices.Fuel.and.Services.App.entity.RoleEntity;
import com.fuelservices.Fuel.and.Services.App.entity.UserEntity;
import com.fuelservices.Fuel.and.Services.App.excption.UserNotFoundException;
import com.fuelservices.Fuel.and.Services.App.repository.RoleRepository;
import com.fuelservices.Fuel.and.Services.App.repository.UserRepository;
import com.fuelservices.Fuel.and.Services.App.util.Roles;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService{

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;


    public AuthServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JWTUtil jwtUtil, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }



    @Override
    @Transactional
    public void signup(CreateSignUpRequest createSignupRequest) {
        RoleEntity roleEntity = roleRepository.findRoleEntityByTitle(Roles.user.name()).orElseThrow();

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(createSignupRequest.getUsername());
        userEntity.setEmail(createSignupRequest.getEmail());
        userEntity.setPassword(createSignupRequest.getPassword());
        userEntity.setPhoneNumber(createSignupRequest.getPhoneNumber().toString());
        userEntity.setRoles(roleEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(createSignupRequest.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public AuthinticationResponse signin(CreateSignInRequest createLoginRequest) {
        if (createLoginRequest.getPassword() == null || createLoginRequest.getUsername() == null){
            throw new NullPointerException();
        }
        String username = createLoginRequest.getUsername().toLowerCase();
        String password = createLoginRequest.getPassword();

        authentication(username, password);

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String accessToken = jwtUtil.generateToken(userDetails);

        AuthinticationResponse response = new AuthinticationResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer " + accessToken);
        return response;
    }
    private void authentication(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));


        } catch (AuthenticationServiceException e) {
            throw new UserNotFoundException("Incorrect username");
        }
    }


}

