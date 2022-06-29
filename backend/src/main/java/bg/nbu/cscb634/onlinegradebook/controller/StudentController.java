package bg.nbu.cscb634.onlinegradebook.controller;

import bg.nbu.cscb634.onlinegradebook.model.Student;
import bg.nbu.cscb634.onlinegradebook.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentServices;

    @GetMapping(path = "/students")
    public String showStudentsPage(Model model) {
        List<Student> students = studentServices.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping(path = "/students/add")
    public String showAddStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "students-add";
    }

    @PostMapping(path = "/students/add")
    public String addStudent(@ModelAttribute Student student) {
        studentServices.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Student student = studentServices.findStudentById(id);
        model.addAttribute("student", student);
        return "students-edit";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@ModelAttribute Student student) throws Exception {
        studentServices.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentServices.deleteStudent(id);
        return "redirect:/students";
    }
}
