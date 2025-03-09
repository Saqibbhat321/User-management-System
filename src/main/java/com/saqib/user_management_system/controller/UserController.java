package com.saqib.user_management_system.controller;

import com.saqib.user_management_system.dto.UserDto;
import com.saqib.user_management_system.entity.UserEntity;
import com.saqib.user_management_system.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/submitUser")
    public String addUser(UserDto dto, Model model) {
        boolean check = service.addUser(dto);
        if (check) {
            List<UserEntity> users = service.getAllUsers();
            model.addAttribute("list", users);
            model.addAttribute("success", "User Added Successfully");
            System.out.println("User Added Successfully");
        } else {
            System.out.println("Failed to Add User");
        }
        return "addUser";
    }

    @GetMapping("/updateUser")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        UserEntity user = service.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("country") String country,
                             @RequestParam("phNo") String phNo, Model model) {
        UserEntity user = service.getUserById(id);
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        user.setPhNo(phNo);
        model.addAttribute("message","Details Updated Successfully ");
        service.updateUser(user);
        return "updateUser";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        UserEntity entity = service.getUserById(id);
        String userName = entity.getName();
        service.deleteUserById(id);
        model.addAttribute("userName", userName);
        return "deleteSuccess";
    }
}
