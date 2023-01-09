package com.itsaboulder.wingedhussar.controllers;

import com.itsaboulder.wingedhussar.dtos.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
}
