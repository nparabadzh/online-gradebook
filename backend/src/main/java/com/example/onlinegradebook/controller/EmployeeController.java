package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.Employee;
import com.example.onlinegradebook.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeServices;

    @GetMapping(path = "/employees")
    public String showEmployeesPage(Model model) {
        List<Employee> employees = employeeServices.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping(path = "/employees/add")
    public String showAddEmployeePage(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees-add";
    }

    @PostMapping(path = "/employees/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeServices.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeServices.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employees-edit";
    }

    @PostMapping("/employees/edit/{id}")
    public String editEmployee(@ModelAttribute Employee employee) throws Exception {
        employeeServices.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeServices.deleteEmployee(id);
        return "redirect:/employees";
    }
}
