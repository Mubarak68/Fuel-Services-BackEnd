package com.fuelservices.Fuel.and.Services.App.controller.user;


import com.fuelservices.Fuel.and.Services.App.bo.user.UpdateUserRequest;
import com.fuelservices.Fuel.and.Services.App.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok().build();
    }

    @PostMapping("/request")
    public ResponseEntity<String> submitRequest(@RequestParam Long garageId) {
        userService.submitRequest(garageId);
        return ResponseEntity.ok("User added a Request !!! ");
    }


}

