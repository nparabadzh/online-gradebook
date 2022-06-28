package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.Grades;
import com.example.onlinegradebook.services.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradesController {
    @Autowired
    private GradesService gradesServices;

    @GetMapping(path = "/grades")
    public List<Grades> showGradesPage(Model model) {
        List<Grades> grades = gradesServices.findAll();
        model.addAttribute("grades", grades);
        return grades;
    }

    @GetMapping(path = "/grades/add")
    public String showAddGradesPage(Model model) {
        model.addAttribute("grades", new Grades());
        return "grades-add";
    }

    @PostMapping(path = "/grades/add")
    public String addGrades(@ModelAttribute Grades grades) {
        gradesServices.addGrades(grades);
        return "redirect:/grades";
    }

    @GetMapping("/grades/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Grades grades = gradesServices.findGradesById(id);
        model.addAttribute("grades", grades);
        return "grades-edit";
    }

    @PostMapping("/grades/edit/{id}")
    public String updateGrades(@ModelAttribute Grades grades) throws Exception {
        gradesServices.updateGrades(grades);
        return "redirect:/grades";
    }

    @GetMapping("/grades/delete/{id}")
    public String deleteGrades(@PathVariable("id") int id) {
        gradesServices.deleteGrades(id);
        return "redirect:/grades";
    }
}
