package bg.nbu.cscb634.onlinegradebook.repositories;

import bg.nbu.cscb634.onlinegradebook.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {
}
