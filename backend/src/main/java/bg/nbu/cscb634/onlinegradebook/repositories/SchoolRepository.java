package bg.nbu.cscb634.onlinegradebook.repositories;


import bg.nbu.cscb634.onlinegradebook.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
