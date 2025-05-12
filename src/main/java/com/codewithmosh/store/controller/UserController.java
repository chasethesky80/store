package com.codewithmosh.store.controller;

import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.service.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(required = false) String sort) {
        sort = StringUtils.isEmpty(sort) || !Arrays.asList("name", "email").contains(sort)
                ? "name" : sort;
        return ResponseEntity.ok(userService.getUsers(sort));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable long id) {
        var user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
