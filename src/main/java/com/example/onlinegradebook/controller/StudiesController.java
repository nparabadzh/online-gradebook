package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudiesController {
    @RequestMapping(path = "/studies")
    public String showStudiesPage(Model model){
        return "Studies";
    }
}
