package io.github.garnaalpak.backend.config;


import io.github.garnaalpak.backend.models.MediaType;
import io.github.garnaalpak.backend.models.Status;
import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.models.UserRole;
import io.github.garnaalpak.backend.repositories.MediaTypeRepository;
import io.github.garnaalpak.backend.repositories.StatusRepository;
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

    private final MediaTypeRepository mediaTypeRepository;
    private final StatusRepository statusRepository;

    private final PasswordEncoder passwordEncoder;

    public void run(String... args) throws Exception {
        createRoleIfNotFound("ROLE_USER");
        createRoleIfNotFound("ROLE_ADMIN");

        createMediaTypeIfNotFound("MOVIE");
        createMediaTypeIfNotFound("TV_SHOW");

        createStatusIfNotFound("PLAN_TO_WATCH");
        createStatusIfNotFound("WATCHING");
        createStatusIfNotFound("COMPLETED");
        createStatusIfNotFound("DROPPED");

        if (!userRepository.existsByUsername("admin")) {
            UserRole adminRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

            User admin = User.builder()
                    .username("admin")
                    .email("admin@watchdeck.com")
                    .firstname("Jakub")
                    .password(passwordEncoder.encode("admin"))
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

    private void createMediaTypeIfNotFound(String name) {
        if (mediaTypeRepository.findMediaTypeByName(name).isEmpty()) {
            MediaType mediaType = new MediaType();
            mediaType.setName(name);
            mediaTypeRepository.save(mediaType);
        }
    }

    private void createStatusIfNotFound(String name) {
        if (statusRepository.findByName(name).isEmpty()) {
            Status status = new Status();
            status.setName(name);
            statusRepository.save(status);
        }
    }
}