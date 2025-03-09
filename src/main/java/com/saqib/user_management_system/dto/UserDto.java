package com.saqib.user_management_system.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String country;
    private String phNo;

    // Getters and Setters
}
