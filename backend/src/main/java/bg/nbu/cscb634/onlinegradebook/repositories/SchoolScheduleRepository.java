package bg.nbu.cscb634.onlinegradebook.repositories;

import bg.nbu.cscb634.onlinegradebook.model.SchoolSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolScheduleRepository extends JpaRepository<SchoolSchedule, Integer>  {
}
