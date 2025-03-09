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
    public String showUpdateUserForm(@RequestParam Long id, Model model) {
        try {
            UserEntity user = service.getUserById(id);
            model.addAttribute("user", user);
            return "updateUser";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error retrieving user.");
            return "errorPage";  // You can create an error page for handling errors
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phNo") String phNo,
                             @RequestParam("country") String country,
                             Model model) {
        try {
            System.out.println("id :" + id);
            System.out.println("email :" + email);
            System.out.println("name :" + name);
            System.out.println("phNo :" + phNo);

            // Call the service to update the user
            boolean isUpdated = service.updateUser(id, name, email, phNo, country);

            // After update, redirect to a different page (like a user list or a confirmation page)
            if (isUpdated) {
                List<UserEntity> list = service.getAllUsers();
                model.addAttribute("list", list);
                return "userList";  // Redirect to a user list or any other page after successful update
            } else {
                model.addAttribute("error", "Update failed");
                return "updateUser";  // If update fails, stay on the update page
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error updating user.");
            return "errorPage";  // Redirect to an error page if something goes wrong
        }
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
