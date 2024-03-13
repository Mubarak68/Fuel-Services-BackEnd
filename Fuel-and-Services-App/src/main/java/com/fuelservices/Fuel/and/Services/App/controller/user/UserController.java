package com.fuelservices.Fuel.and.Services.App.controller.user;


import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.bo.user.UserRequestSubmission;
import com.fuelservices.Fuel.and.Services.App.entity.RequestEntity;
import com.fuelservices.Fuel.and.Services.App.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest userRequest, @RequestParam Long user_Id) {
        userService.updateUser(userRequest, user_Id);
        return ResponseEntity.ok("User is updated!!");
    }

    @PostMapping("/add-request")
    public ResponseEntity<String> submitRequest(@RequestParam Long service_Id, @RequestBody UserRequestSubmission userRequestSubmission) {
        userService.submitRequest(service_Id,userRequestSubmission);
        return ResponseEntity.ok("User added a Request !!! ");
    }

    @GetMapping("/request_list")
    public ResponseEntity<List<RequestEntity>> getAddRequests() {
        List<RequestEntity> allRequests = userService.getAllRequest();
        return ResponseEntity.ok(allRequests);
    }


}

