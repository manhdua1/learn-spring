package com.manhdua.learnspring.controller;

import com.manhdua.learnspring.dto.request.ApiResponse;
import com.manhdua.learnspring.dto.request.UserCreationRequest;
import com.manhdua.learnspring.dto.request.UserUpdateRequest;
import com.manhdua.learnspring.dto.response.UserResponse;
import com.manhdua.learnspring.entity.User;
import com.manhdua.learnspring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(userCreationRequest));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable UUID userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable UUID userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
