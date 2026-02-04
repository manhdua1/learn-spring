package com.manhdua.learnspring.service;

import com.manhdua.learnspring.dto.request.UserCreationRequest;
import com.manhdua.learnspring.dto.request.UserUpdateRequest;
import com.manhdua.learnspring.entity.User;
import com.manhdua.learnspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if (userRepository.existsByUserName(request.getUserName())) {
            throw new RuntimeException("Username existed");
        }

        user.setUserName(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());

        userRepository.save(user);
        return user;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(UUID userId, UserUpdateRequest request) {
        User user = getUser(userId);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
