package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.dto.AddWatchlistDto;
import io.github.garnaalpak.backend.dto.DeleteWatchlistDto;
import io.github.garnaalpak.backend.dto.EditStatusWatchlistDto;
import io.github.garnaalpak.backend.models.Watchlist;

import java.util.Collection;

public interface IWatchlistService {
    Collection<Watchlist> getAllWatchlist();

    void addToWatchList(AddWatchlistDto watchlistDto);

    void deleteFromWatchList(DeleteWatchlistDto deleteWatchlistDto);

    void changeStatus(EditStatusWatchlistDto request);
}
