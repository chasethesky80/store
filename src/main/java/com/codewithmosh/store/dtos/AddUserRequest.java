package com.codewithmosh.store.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String name;
    private String email;
    private String password;
}
