package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(path = "/users")
    public String ShowUsersPage(Model model){
        return "Users";
    }
}
