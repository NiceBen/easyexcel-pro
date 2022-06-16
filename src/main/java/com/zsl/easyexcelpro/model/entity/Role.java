package com.zsl.easyexcelpro.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    private Long id;

    private String roleName;

    private String description;
}
