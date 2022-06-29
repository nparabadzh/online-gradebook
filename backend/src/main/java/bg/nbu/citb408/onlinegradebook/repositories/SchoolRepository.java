package bg.nbu.citb408.onlinegradebook.repositories;


import bg.nbu.citb408.onlinegradebook.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
