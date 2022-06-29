package bg.nbu.citb408.onlinegradebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.nbu.citb408.onlinegradebook.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    RoleEntity findByName(String name);
}