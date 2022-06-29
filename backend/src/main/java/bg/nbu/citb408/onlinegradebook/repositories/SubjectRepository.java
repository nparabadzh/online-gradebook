package bg.nbu.citb408.onlinegradebook.repositories;

import bg.nbu.citb408.onlinegradebook.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
