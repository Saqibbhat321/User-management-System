package com.saqib.user_management_system.controller;

import com.saqib.user_management_system.entity.RegisterEntity;
import com.saqib.user_management_system.entity.UserEntity;
import com.saqib.user_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {


    @Autowired
    private UserService service;

    @GetMapping("/onLogin")
    public String onLogin(@RequestParam String email, @RequestParam String password, Model model) {

        RegisterEntity entity = service.checkLogin(email, password);
        if (entity != null) {
            System.out.println("Registration Successful");
            List<UserEntity> list = service.getAllUsers();
            model.addAttribute("list",list);
            System.out.println(list);
            model.addAttribute("success", "You are Logged As " + entity.getEmail());
            return "mainPage";
        } else {
            System.out.println("Registration Failed");
            model.addAttribute("error", "Invalid email or password. Please try again.");
            return "login";
        }
    }
}
