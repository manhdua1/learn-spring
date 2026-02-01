package com.manhdua.learnspring.controller;

import com.manhdua.learnspring.dto.request.UserCreationRequest;
import com.manhdua.learnspring.entity.User;
import com.manhdua.learnspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest userCreationRequest) {
        return userService.createUser(userCreationRequest);
    }
}
