package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.AddUserRequest;
import com.codewithmosh.store.dtos.UpdateUserRequest;
import com.codewithmosh.store.dtos.UserResponse;
import com.codewithmosh.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "createdAt", expression= "java(java.time.LocalDateTime.now())")
    UserResponse toUserDto(User user);
    User toUser(AddUserRequest user);
    User toUser(UpdateUserRequest user);
}
