package com.ozguryazilim.labwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String anamenu() {
        return "anamenu";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
