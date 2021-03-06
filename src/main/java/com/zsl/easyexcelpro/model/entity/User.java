package com.zsl.easyexcelpro.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;

    private String username;

    private String password;

    private String phoneNum;

    private String email;

    private Role role;
}
