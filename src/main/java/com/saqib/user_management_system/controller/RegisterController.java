package com.saqib.user_management_system.controller;

import com.saqib.user_management_system.dto.RegisterDto;
import com.saqib.user_management_system.entity.RegisterEntity;
import com.saqib.user_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    private UserService service;
    @RequestMapping("/registerServlet")
    public String registration(RegisterDto dto)
    {

      boolean check =   service.validate(dto);
      if(check)
      {
          System.out.println("registration successful");
      }else {
          System.out.println("Registration Failed");
      }


        return "index";

    }
}
