package io.github.garnaalpak.backend.config;


import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.models.UserRole;
import io.github.garnaalpak.backend.repositories.UserRepository;
import io.github.garnaalpak.backend.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final UserRoleRepository roleRepository;
    private final UserRepository userRepository;

    //todo
    //to security
//    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // 1. Tworzenie Ról
        createRoleIfNotFound("ROLE_USER");
        createRoleIfNotFound("ROLE_ADMIN");

        // 2. Tworzenie Admina
        if (!userRepository.existsByUsername("admin")) {
            UserRole adminRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

            User admin = User.builder()
                    .username("admin")
                    .email("admin@watchdeck.com")
//                    .password(passwordEncoder.encode("admin"))
                    .password("admin")
                    .role(adminRole)
                    .build();

            userRepository.save(admin);
        }
    }

    private void createRoleIfNotFound(String name) {
        if (roleRepository.findByName(name).isEmpty()) {
            UserRole role = new UserRole();
            role.setName(name);
            roleRepository.save(role);
        }
    }
}