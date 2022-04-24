package ma.emsi.user_roles.repositories;

import ma.emsi.user_roles.entities.Role;
import ma.emsi.user_roles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
