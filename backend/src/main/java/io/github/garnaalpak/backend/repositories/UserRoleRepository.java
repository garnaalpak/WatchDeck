package io.github.garnaalpak.backend.repositories;

import io.github.garnaalpak.backend.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByName(String name);

    boolean existsByName(String name);
}
