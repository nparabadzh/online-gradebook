package bg.nbu.cscb634.onlinegradebook.controller;

import bg.nbu.cscb634.onlinegradebook.model.Subject;
import bg.nbu.cscb634.onlinegradebook.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectServices;

    @GetMapping(path = "/subjects")
    public String showSubjectsPage(Model model) {
        List<Subject> subjects = subjectServices.findAll();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @GetMapping(path = "/subjects/add")
    public String showAddSubjectPage(Model model) {
        model.addAttribute("subject", new Subject());
        return "subjects-add";
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
}
