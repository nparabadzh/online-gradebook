package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.SchoolSchedule;
import com.example.onlinegradebook.services.SchoolScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SchoolScheduleController {
    @Autowired
    private SchoolScheduleService schoolScheduleServices;

    @GetMapping(path = "/schoolSchedules")
    public String showSchoolSchedulesPage(Model model) {
        List<SchoolSchedule> schoolSchedules = schoolScheduleServices.findAll();
        model.addAttribute("schoolSchedules", schoolSchedules);
        return "schoolSchedules";
    }

    @GetMapping(path = "/schoolSchedules/add")
    public String showAddSchoolSchedulePage(Model model) {
        model.addAttribute("schoolSchedule", new SchoolSchedule());
        return "schoolSchedules-add";
    }

    @PostMapping(path = "/schoolSchedules/add")
    public String addSchoolSchedule(@ModelAttribute SchoolSchedule schoolSchedule) {
        schoolScheduleServices.addSchoolSchedule(schoolSchedule);
        return "redirect:/schoolSchedules";
    }

    @GetMapping("/schoolSchedules/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        SchoolSchedule schoolSchedule = schoolScheduleServices.findSchoolScheduleById(id);
        model.addAttribute("schoolSchedule", schoolSchedule);
        return "schoolSchedules-edit";
    }

    @PostMapping("/schoolSchedules/edit/{id}")
    public String updateSchoolSchedule(@ModelAttribute SchoolSchedule schoolSchedule) throws Exception {
        schoolScheduleServices.updateSchoolSchedule(schoolSchedule);
        return "redirect:/schoolSchedules";
    }

    @GetMapping("/schoolSchedules/delete/{id}")
    public String deleteSchoolSchedule(@PathVariable("id") int id) {
        schoolScheduleServices.deleteSchoolSchedule(id);
        return "redirect:/schoolSchedules";
    }
}
