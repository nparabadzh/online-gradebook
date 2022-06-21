package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.Employee;
import com.example.onlinegradebook.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public void addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        return employee;
    }

    public void updateEmployee(@ModelAttribute Employee employee) throws Exception {
        Employee employeeInDB = employeeRepository.findById(employee.getID()).orElse(null);
        if (employeeInDB != null) {
            employeeInDB.setName(employee.getName());
            employeeInDB.setEGN(employee.getEGN());
            employeeInDB.setAddress(employee.getAddress());
            employeeInDB.setRole(employee.getRole());
            employeeInDB.setSalary(employee.getSalary());
            employeeInDB.setQualification(employee.getQualification());
            employeeRepository.save(employeeInDB);
        } else {
            throw new Exception("Employee not found");
        }
    }

    public void deleteEmployee(@PathVariable("id") int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.delete(employee);
    }
}
