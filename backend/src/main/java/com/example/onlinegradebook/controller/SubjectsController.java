package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectsController {
    @RequestMapping(path = "/subjects")
    public String showSubjectsPage(Model model){
        return "Subjects";
    }
}
