package ma.emsi.user_roles.repositories;

import ma.emsi.user_roles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);

}
