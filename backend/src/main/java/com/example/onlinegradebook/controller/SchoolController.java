package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.*;
import com.example.onlinegradebook.repositories.SchoolRepository;
import com.example.onlinegradebook.services.EmployeeService;
import com.example.onlinegradebook.services.SchoolService;
import com.example.onlinegradebook.services.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolServices;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolRepository schoolRepo;

    @GetMapping(path = "/schools")
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolServices.findAll();
        return ResponseEntity.ok().body(schools);
    }

    @GetMapping(path = "/schools/add")
    public String showAddSchoolPage(Model model) {
        model.addAttribute("school", new School());
        return "schools-add";
    }

    @PostMapping(path = "/schools/add")
    public ResponseEntity<?>  addSchool(@RequestBody SchoolPost schoolPost) {
        School school = new School (
                schoolPost.getName(),
                schoolPost.getAddress(),
                schoolPost.getClasses()
        );
        schoolRepo.save(school);
        JSONObject schoolInfo = new JSONObject();
        schoolInfo.put("email", school.getName());
        schoolInfo.put("firstName", school.getAddress());
        schoolInfo.put("lastName", school.getClasses());
        JSONObject resp = new JSONObject();
        resp.put("message", "Created");
        resp.put("user", schoolInfo);
        return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
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
