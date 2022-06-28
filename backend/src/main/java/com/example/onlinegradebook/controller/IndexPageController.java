package com.example.onlinegradebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexPageController {
    @RequestMapping(path = "/home")
    public String showIndexPage(Model model){
        return "Index Page";
    }
}
