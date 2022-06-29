package bg.nbu.cscb634.onlinegradebook.repositories;

import bg.nbu.cscb634.onlinegradebook.model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradesRepository extends JpaRepository<Grades, Integer> {
}
