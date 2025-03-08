package com.saqib.user_management_system.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginDto {

    private int id;
    private String email;
    private String password;

}
