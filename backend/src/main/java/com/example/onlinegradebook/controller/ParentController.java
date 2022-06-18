package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {
    @RequestMapping(path = "/parents")
    public String showParentsPage(Model model){
        return "Parents";
    }
}
