package com.saqib.user_management_system.controller;

import com.saqib.user_management_system.dto.UserDto;
import com.saqib.user_management_system.entity.UserEntity;
import com.saqib.user_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public String getAllUsers(Model model)
    {
        List<UserEntity> users =  service.getAllUsers();
        model.addAttribute("users",users);
        return "mainPage.jsp";
    }
}
