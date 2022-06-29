package bg.nbu.citb408.onlinegradebook.repositories;

import bg.nbu.citb408.onlinegradebook.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {
}
