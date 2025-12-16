package io.github.garnaalpak.backend.repositories;

import io.github.garnaalpak.backend.models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    List<Watchlist> findAllByUserId(Integer userId);

    boolean existsByUserIdAndTmdbId(Integer userId, String tmdbId);

    Optional<Watchlist> findByUserIdAndTmdbId(Integer userId, String tmdbId);
}