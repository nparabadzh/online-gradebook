package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {
    @RequestMapping("/students")
    public String showStudentsPage(Model model){
        return "Students";
    }
}
