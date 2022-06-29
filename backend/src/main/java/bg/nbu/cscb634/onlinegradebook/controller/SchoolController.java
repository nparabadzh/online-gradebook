package bg.nbu.cscb634.onlinegradebook.controller;

import bg.nbu.cscb634.onlinegradebook.model.School;
import bg.nbu.cscb634.onlinegradebook.services.EmployeeService;
import bg.nbu.cscb634.onlinegradebook.services.SchoolService;
import bg.nbu.cscb634.onlinegradebook.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SchoolController {
    @Autowired
    private SchoolService schoolServices;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/schools")
    public String showSchoolsPage(Model model) {
        List<School> schools = schoolServices.findAll();
        model.addAttribute("schools", schools);
        return "schools";
    }

    @GetMapping(path = "/schools/add")
    public String showAddSchoolPage(Model model) {
        model.addAttribute("school", new School());
        return "schools-add";
    }

    @PostMapping(path = "/schools/add")
    public String addSchool(@ModelAttribute School school) {
        schoolServices.addSchool(school);
        return "redirect:/schools";
    }

    @GetMapping("/schools/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        School school = schoolServices.findSchoolById(id);
        model.addAttribute("school", school);
        return "schools-edit";
    }

    @PostMapping("/schools/edit/{id}")
    public String updateSchool(@ModelAttribute School school) throws Exception {
        schoolServices.updateSchool(school);
        return "redirect:/schools";
    }

    @GetMapping("/schools/delete/{id}")
    public String deleteSchool(@PathVariable("id") int id) {
        schoolServices.deleteSchool(id);
        return "redirect:/schools";
    }
}
