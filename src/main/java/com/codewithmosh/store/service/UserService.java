package com.codewithmosh.store.service;

import com.codewithmosh.store.model.User;
import com.codewithmosh.store.model.UserRequest;
import com.codewithmosh.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Autowired
    public UserService(final UserRepository userRepository,
                       final NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(final UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.email()) != null) {
            throw new IllegalArgumentException(String.format("User with email %s already " +
                    "exists", userRequest.email()));
        }
        userRepository.save(toUser(userRequest));
        notificationService.send("Message notified", userRequest.email());
    }

    private User toUser(final UserRequest userRequest) {
        return new User(userRequest.id(), userRequest.email(), userRequest.password(), userRequest.name());
    }
}
