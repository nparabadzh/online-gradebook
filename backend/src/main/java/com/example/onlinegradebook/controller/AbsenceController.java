package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.Absence;
import com.example.onlinegradebook.services.AbsenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AbsenceController {
    @Autowired
    private AbsenceServices absenceServices;

    @GetMapping(path = "/absences")
    public String showAbsencesPage(Model model) {
        List<Absence> absences = absenceServices.findAll();
        model.addAttribute("absences", absences);
        return "absences";
    }

    @GetMapping(path = "/absences/add")
    public String showAddAbsencePage(Model model) {
        model.addAttribute("absence", new Absence());
        return "absences-add";
    }

    @PostMapping(path = "/absences/add")
    public String addAbsence(@ModelAttribute Absence absence) {
        absenceServices.addAbsence(absence);
        return "redirect:/absences";
    }

    @GetMapping("/absences/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Absence absence = absenceServices.findAbsenceById(id);
        model.addAttribute("absence", absence);
        return "absences-edit";
    }

    @PostMapping("/absences/edit/{id}")
    public String updateAbsence(@ModelAttribute Absence absence) throws Exception {
        absenceServices.updateAbsence(absence);
        return "redirect:/absences";
    }

    @GetMapping("/absences/delete/{id}")
    public String deleteAbsence(@PathVariable("id") int id) {
        absenceServices.deleteAbsence(id);
        return "redirect:/absences";
    }
}
