package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.SchoolClass;
import com.example.onlinegradebook.services.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class SchoolClassController {
    @Autowired
    private SchoolClassService schoolClassServices;

    @GetMapping(path = "/schoolClasses")
    public String showSchoolClassPage(Model model) {
        List<SchoolClass> schoolClass = schoolClassServices.findAll();
        model.addAttribute("schoolClass", schoolClass);
        return "schoolClasses";
    }

    @GetMapping(path = "/schoolClasses/add")
    public String showAddSchoolClassPage(Model model) {
        model.addAttribute("schoolClass", new SchoolClass());
        return "schoolClasses-add";
    }

    @PostMapping(path = "/schoolClasses/add")
    public String addSchoolClass(@ModelAttribute SchoolClass schoolClass) {
        schoolClassServices.addSchoolClass(schoolClass);
        return "redirect:/schoolClasses";
    }

    @GetMapping("/schoolClasses/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        SchoolClass schoolClass = schoolClassServices.findSchoolClassById(id);
        model.addAttribute("schoolClass", schoolClass);
        return "schoolClasses-edit";
    }

    @PostMapping("/schoolClasses/edit/{id}")
    public String updateSchoolClass(@ModelAttribute SchoolClass schoolClass) throws Exception {
        schoolClassServices.updateSchoolClass(schoolClass);
        return "redirect:/schoolClasses";
    }

    @GetMapping("/schoolClasses/delete/{id}")
    public String deleteSchoolClass(@PathVariable("id") int id) {
        schoolClassServices.deleteSchoolClass(id);
        return "redirect:/schoolClasses";
    }
}
