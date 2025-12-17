package io.github.garnaalpak.backend.controllers;

import io.github.garnaalpak.backend.dto.AddWatchlistDto;
import io.github.garnaalpak.backend.dto.EditStatusWatchlistDto;
import io.github.garnaalpak.backend.dto.WatchlistResponseDto;
import io.github.garnaalpak.backend.models.Watchlist;
import io.github.garnaalpak.backend.services.IWatchlistService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@AllArgsConstructor
@RestController
@RequestMapping("/api/watchlist")
public class WatchListController {
    private final IWatchlistService watchlistService;


    @GetMapping
    public ResponseEntity<Collection<WatchlistResponseDto>> getAllList()
    {
        return ResponseEntity.ok(watchlistService.getAllWatchlist());
    }

    @PostMapping
    public ResponseEntity<String> addToWatchlist(@Valid @RequestBody AddWatchlistDto request) {
        watchlistService.addToWatchList(request);
        return ResponseEntity.ok("Dodano do listy");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFromWatchlist(
            @RequestParam String tmdbId,
            @RequestParam String mediaType
    ) {
        watchlistService.deleteFromWatchList(tmdbId, mediaType);
        return ResponseEntity.ok("Usunięto z listy");
    }


    @PatchMapping
    public ResponseEntity<String> changeStatus(@Valid @RequestBody EditStatusWatchlistDto request) {
        watchlistService.changeStatus(request);
        return ResponseEntity.ok("Status zaktualizowany");
    }
}
