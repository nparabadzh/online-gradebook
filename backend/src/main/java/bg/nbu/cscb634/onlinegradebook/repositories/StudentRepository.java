package bg.nbu.cscb634.onlinegradebook.repositories;

import bg.nbu.cscb634.onlinegradebook.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
