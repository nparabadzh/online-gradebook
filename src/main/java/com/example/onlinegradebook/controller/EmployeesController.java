package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {
    @RequestMapping(path = "/employees")
    public String showEmployeesPage(Model model){
        return "Employees";
    }
}
