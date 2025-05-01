package com.codewithmosh.store.controller;

import com.codewithmosh.store.model.UserRequest;
import com.codewithmosh.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final UserService userService;

    @Autowired
    public NotificationController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/notify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendNotification(@RequestBody UserRequest userRequest) {
        this.userService.registerUser(userRequest);
        return ResponseEntity.ok("result");
    }
}
