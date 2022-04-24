package ma.emsi.user_roles.service;

import ma.emsi.user_roles.entities.Role;
import ma.emsi.user_roles.entities.User;

public interface UserService {

    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName);
    User authenticate(String userName,String password);
}
