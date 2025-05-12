package com.codewithmosh.store.controller;

import com.codewithmosh.store.dtos.AddUserRequest;
import com.codewithmosh.store.dtos.UpdateUserRequest;
import com.codewithmosh.store.dtos.UserResponse;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repository.UserRepository;
import com.codewithmosh.store.service.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserMapper userMapper, UserRepository userRepository) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponse>> getAllUsers(@RequestParam(required = false) String sort) {
        sort = StringUtils.isEmpty(sort) || !Arrays.asList("name", "email").contains(sort)
                ? "name" : sort;
        return ResponseEntity.ok(userService.getUsers(sort));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUser(@PathVariable long id) {
        var user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@RequestBody AddUserRequest userRequest) {
        final User user = userMapper.toUser(userRequest);
        final User savedUser = userRepository.save(user);
        final UserResponse userResponse = userMapper.toUserDto(savedUser);
        return ResponseEntity.created(URI.create("/users/" + savedUser.getId())).body(
                userResponse
        );
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        userRepository.findById(updateUserRequest.getId())
                .orElseThrow(() -> new RuntimeException("User with id " + updateUserRequest.getId() + " not found"));
        final User user = userMapper.toUser(updateUserRequest);
        final User savedUser = userRepository.save(user);
        return ResponseEntity.ok(userMapper.toUserDto(savedUser));
    }
}
