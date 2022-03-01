package team.bahor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import team.bahor.entity.user.User;
import team.bahor.entity.user.UserPermission;
import team.bahor.entity.user.UserRole;
import team.bahor.enums.user.Roles;
import team.bahor.repository.user.UserPermissionRepository;
import team.bahor.repository.user.UserRepository;
import team.bahor.repository.user.UserRoleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@EnableJpaAuditing
@SpringBootApplication

public class TaskManagementApplication {
    private final UserPermissionRepository userPermissionRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TaskManagementApplication(UserPermissionRepository userPermissionRepository, UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userPermissionRepository = userPermissionRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(TaskManagementApplication.class, args);
    }


 //   @Transactional
 //   @Bean
    CommandLineRunner run() {
        return args -> {
            User superAdmin = new User();
            superAdmin.setPassword(passwordEncoder.encode("123"));
            superAdmin.setCode(UUID.randomUUID().toString());
            superAdmin.setCreatedAt(LocalDateTime.now());
            superAdmin.setUsername("super");
            UserRole role = new UserRole();
            role.setName(Roles.SUPER_ADMIN.name());
            role.setCode(Roles.SUPER_ADMIN.getCode());
            List<UserPermission> userPermissions = Roles.SUPER_ADMIN.getPermissions().stream()
                    .map(permission -> new UserPermission(permission.name(), permission.getCode()))
                    .collect(Collectors.toList());
            role.setPermissions(userPermissions);
            superAdmin.setUserRole(role);
            superAdmin.setOrganizationId(1L);
            superAdmin.setStatus(0);
            superAdmin.setOrganizationId(1L);
//            userPermissionRepository.saveAll(userPermissions);
//            userRoleRepository.save(role);
            userRepository.save(superAdmin);


        };
    }
}
