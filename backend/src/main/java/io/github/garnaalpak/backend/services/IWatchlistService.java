package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.dto.AddWatchlistDto;
import io.github.garnaalpak.backend.dto.EditStatusWatchlistDto;
import io.github.garnaalpak.backend.dto.WatchlistResponseDto;

import java.util.Collection;

public interface IWatchlistService {
    Collection<WatchlistResponseDto> getAllWatchlist();

    void addToWatchList(AddWatchlistDto watchlistDto);

    void deleteFromWatchList(String tmdbId, String mediaType);

    void changeStatus(EditStatusWatchlistDto request);
}
