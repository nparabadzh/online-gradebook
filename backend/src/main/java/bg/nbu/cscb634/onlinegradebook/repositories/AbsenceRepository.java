package bg.nbu.cscb634.onlinegradebook.repositories;

import bg.nbu.cscb634.onlinegradebook.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
}
