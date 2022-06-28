package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.Subject;
import com.example.onlinegradebook.services.SubjectService;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectServices;

    @GetMapping(path = "/subjects")
    public List<Subject> showSubjectsPage(Model model) {
        List<Subject> subjects = subjectServices.findAll();
        model.addAttribute("subjects", subjects);
        return subjects;
    }

    @GetMapping(path = "/subjects/add")
    public Subject showAddSubjectPage(Model model) {
        Subject newSubject = new Subject();
        model.addAttribute("subject", newSubject);
        return newSubject;
    }

    @PostMapping(path = "/subjects/add")
    public String addSubject(@ModelAttribute Subject subject) {
        subjectServices.addSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Subject subject = subjectServices.findSubjectById(id);
        model.addAttribute("subject", subject);
        return "subjects-edit";
    }

    @PostMapping("/subjects/edit/{id}")
    public String updateSubject(@ModelAttribute Subject subject) throws Exception {
        subjectServices.updateSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/delete/{id}")
    public String deleteSubject(@PathVariable("id") int id) {
        subjectServices.deleteSubject(id);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/student/{id}")
    public List<Subject> getAllSubjectsForStudentId(@PathVariable("id") int id) {
        return subjectServices.findAllSubjectsForStudentWithId(id);
    }
}
