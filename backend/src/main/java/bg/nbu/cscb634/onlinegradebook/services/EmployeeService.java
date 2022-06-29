package bg.nbu.cscb634.onlinegradebook.services;

import bg.nbu.cscb634.onlinegradebook.repositories.EmployeeRepository;
import bg.nbu.cscb634.onlinegradebook.repositories.UserRepository;
import bg.nbu.cscb634.onlinegradebook.model.Employee;
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

    @Autowired
    private UserRepository userRepository;

    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public void addEmployee(@ModelAttribute Employee employee) {
        userRepository.save(employee.getUser());
        employeeRepository.save(employee);
    }

    public Employee findEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        return employee;
    }

    public void updateEmployee(@ModelAttribute Employee employee) throws Exception {
        Employee employeeInDB = employeeRepository.findById(employee.getId()).orElse(null);
        if (employeeInDB != null) {
            employeeInDB.setUser(employee.getUser());
            employeeInDB.setSalary(employee.getSalary());
            employeeInDB.setQualification(employee.getQualification());
            userRepository.save(employeeInDB.getUser());
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
