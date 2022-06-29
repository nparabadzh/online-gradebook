package bg.nbu.citb408.onlinegradebook.repositories;

import bg.nbu.citb408.onlinegradebook.model.SchoolSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolScheduleRepository extends JpaRepository<SchoolSchedule, Integer>  {
}
