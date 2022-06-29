package bg.nbu.citb408.onlinegradebook.controller;

import bg.nbu.citb408.onlinegradebook.model.Grades;
import bg.nbu.citb408.onlinegradebook.services.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GradesController {
    @Autowired
    private GradesService gradesServices;

    @GetMapping(path = "/grades")
    public String showGradessPage(Model model) {
        List<Grades> grades = gradesServices.findAll();
        model.addAttribute("grades", grades);
        return "grades";
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
