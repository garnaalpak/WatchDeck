package io.github.garnaalpak.backend.repositories;

import io.github.garnaalpak.backend.models.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaTypeRepository extends JpaRepository<MediaType, Integer> {
    Optional<MediaType> findMediaTypeByName(String name);
}