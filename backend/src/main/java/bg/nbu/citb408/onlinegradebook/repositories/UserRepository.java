package bg.nbu.citb408.onlinegradebook.repositories;

import bg.nbu.citb408.onlinegradebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);

}