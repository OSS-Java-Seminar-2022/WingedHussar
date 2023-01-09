package com.itsaboulder.wingedhussar.controllers;

import com.itsaboulder.wingedhussar.dtos.UserDto;
import com.itsaboulder.wingedhussar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(final Model model){
        model.addAttribute("userData", new UserDto());
        return "account/register";
    }

    @PostMapping("/register")
    public String userRegistration(final @Valid UserDto userDto, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userDto);
            return "account/register";
        }
        try {
            userService.register(userDto);
        }catch (Exception e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", userDto);
            return "account/register";
        }
        return "redirect/starter";
    }
}
