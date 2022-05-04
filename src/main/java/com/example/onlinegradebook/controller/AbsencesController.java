package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbsencesController {
    @RequestMapping(path = "/absences")
    public String showAbsencesPage(Model model){
        return "Absences";
    }
}
