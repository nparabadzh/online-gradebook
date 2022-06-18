package com.example.onlinegradebook.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @RequestMapping(path = "/topics")
    private String showTopicsPage(Model model){
        return "Topics";
    }
}
