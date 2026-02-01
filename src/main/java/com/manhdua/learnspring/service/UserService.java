package com.manhdua.learnspring.service;

import com.manhdua.learnspring.dto.request.UserCreationRequest;
import com.manhdua.learnspring.entity.User;
import com.manhdua.learnspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        user.setUserName(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());

        userRepository.save(user);
        return user;
    }
}
