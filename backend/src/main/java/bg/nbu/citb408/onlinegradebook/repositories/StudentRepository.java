package bg.nbu.citb408.onlinegradebook.repositories;

import bg.nbu.citb408.onlinegradebook.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
