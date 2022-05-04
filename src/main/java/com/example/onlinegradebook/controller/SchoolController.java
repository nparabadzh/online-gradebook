package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    @RequestMapping(path = "/schools")
    public String showSchoolsPage(Model model){
        return "Schools";
    }
}
