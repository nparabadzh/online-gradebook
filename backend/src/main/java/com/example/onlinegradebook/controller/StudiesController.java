package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.Studies;
import com.example.onlinegradebook.services.StudiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudiesController {
    @Autowired
    private StudiesServices studiesServices;

    @GetMapping(path = "/studies")
    public String showStudiesPage(Model model) {
        List<Studies> studies = studiesServices.findAll();
        model.addAttribute("studies", studies);
        return "studies";
    }

    @GetMapping(path = "/studies/add")
    public String showAddStudiesPage(Model model) {
        model.addAttribute("studies", new Studies());
        return "studies-add";
    }

    @PostMapping(path = "/studies/add")
    public String addStudies(@ModelAttribute Studies studies) {
        studiesServices.addStudies(studies);
        return "redirect:/studies";
    }

    @GetMapping("/studies/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Studies studies = studiesServices.findStudiesById(id);
        model.addAttribute("studies", studies);
        return "studies-edit";
    }

    @PostMapping("/studies/edit/{id}")
    public String updateStudies(@ModelAttribute Studies studies) throws Exception {
        studiesServices.updateStudies(studies);
        return "redirect:/studies";
    }

    @GetMapping("/studies/delete/{id}")
    public String deleteStudies(@PathVariable("id") int id) {
        studiesServices.deleteStudies(id);
        return "redirect:/studies";
    }
}
