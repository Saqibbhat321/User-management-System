package com.saqib.user_management_system.controller;

import com.saqib.user_management_system.dto.UserDto;
import com.saqib.user_management_system.entity.UserEntity;
import com.saqib.user_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AddUserController {

    @Autowired
    private UserService service;

    @PostMapping("/submitUser")
    public String addUser(UserDto dto)
    {
        boolean check =  service.addUser(dto);
        if(check)
        {
            System.out.println("User Added Successfully");
        }
        else
        {
            System.out.println("Failed to Add User");
        }

        return "mainPage.jsp";
    }
}
