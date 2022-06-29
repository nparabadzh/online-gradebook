package bg.nbu.cscb634.onlinegradebook.repositories;

import bg.nbu.cscb634.onlinegradebook.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
