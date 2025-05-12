package com.codewithmosh.store.service;

import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;;
    private final UserMapper userMapper;

    @Autowired
    public UserService(final UserRepository userRepository,
                       final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserDto getUser(final long id) {
        var user = userRepository.findById(id).orElse(null);
        return userMapper.toUserDto(user);
    }

    @Transactional
    public List<UserDto> getUsers(final String sort) {
        return userRepository.findAll(Sort.by(sort)).stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
