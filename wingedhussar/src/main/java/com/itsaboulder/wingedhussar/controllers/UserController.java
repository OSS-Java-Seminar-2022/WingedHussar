package com.itsaboulder.wingedhussar.controllers;

import com.itsaboulder.wingedhussar.dtos.UserDto;
import com.itsaboulder.wingedhussar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String viewRegisterPage(Model model){
        var userDto = new UserDto();
        model.addAttribute("UserRegistration", userDto);
        return "register";
    }
    @PostMapping("/register_process")
    public String userRegistration(UserDto userDto, Model model){
        try {
            userDto.setRole("passenger");
            userService.register(userDto);
        }catch (Exception e){
            model.addAttribute("registrationForm", userDto);
            return "register";
        }
        return "register_success";
    }

    @GetMapping("/login")
    public String viewLoginPage(){
        return "login";
    }

    @PostMapping("/login_process")
    public String userLogin(UserDto userDto,Model model){
        return "index";
    }
}
