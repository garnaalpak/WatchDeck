package io.github.garnaalpak.backend.repositories;

import io.github.garnaalpak.backend.models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    List<Watchlist> findAllByUserId(Integer userId);

    boolean existsByUserIdAndTmdbId(Integer userId, String tmdbId);

    boolean existsByUserIdAndTmdbIdAndMediaType_Name(Integer userId, String tmdbId, String mediaTypeName);

    Optional<Watchlist> findByUserIdAndTmdbId(Integer userId, String tmdbId);

    Optional<Watchlist> findByUserIdAndTmdbIdAndMediaType_Name(Integer userId, String tmdbId, String mediaTypeName);

    @Transactional
    void deleteByTmdbIdAndUserId(String tmdbId, Integer userId);

    void deleteByTmdbIdAndUserIdAndMediaType_Name(String tmdbId, Integer userId, String mediaTypeName);
}