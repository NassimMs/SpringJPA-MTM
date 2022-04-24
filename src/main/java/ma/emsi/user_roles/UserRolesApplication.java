package ma.emsi.user_roles;

import ma.emsi.user_roles.entities.Role;
import ma.emsi.user_roles.entities.User;
import ma.emsi.user_roles.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UserRolesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRolesApplication.class, args);
    }


    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u = new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2 = new User();
            u.setUsername("admin");
            u.setPassword("123456");
            userService.addNewUser(u2);

            Role role1 = new Role();
            role1.setRoleName("STUDENT");
            userService.addNewRole(role1);


            userService.addRoleToUser("user1","STUDENT");

            try {
                User user = userService.authenticate("user1","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("Roles=>");
                user.getRoles().forEach(role -> {
                    System.out.println("Role=>"+role.toString());
                });

            }catch (Exception exception){
                exception.printStackTrace();
            }
        };
    }
}
