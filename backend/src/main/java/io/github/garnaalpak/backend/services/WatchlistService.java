package io.github.garnaalpak.backend.services;

import io.github.garnaalpak.backend.dto.AddWatchlistDto;
import io.github.garnaalpak.backend.dto.DeleteWatchlistDto;
import io.github.garnaalpak.backend.dto.EditStatusWatchlistDto;
import io.github.garnaalpak.backend.exceptions.BadRequestException;
import io.github.garnaalpak.backend.exceptions.NotFoundException;
import io.github.garnaalpak.backend.models.Status;
import io.github.garnaalpak.backend.models.User;
import io.github.garnaalpak.backend.models.Watchlist;
import io.github.garnaalpak.backend.repositories.MediaTypeRepository;
import io.github.garnaalpak.backend.repositories.StatusRepository;
import io.github.garnaalpak.backend.repositories.UserRepository;
import io.github.garnaalpak.backend.repositories.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
public class WatchlistService implements IWatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final StatusRepository statusRepository;
    private final MediaTypeRepository mediaTypeRepository;
    private final UserRepository userRepository;

    @Override
    public Collection<Watchlist> getAllWatchlist()
    {
        User user = getCurrentUser();
        return watchlistRepository.findAllByUserId(user.getId());
    }

    @Override
    public void addToWatchList(AddWatchlistDto watchlistDto)
    {
        User user = getCurrentUser();

        if (watchlistRepository.existsByUserIdAndTmdbIdAndMediaType_Name(user.getId(), watchlistDto.getTmdbId(), watchlistDto.getMediaType())) {
            throw new BadRequestException("Ten " + watchlistDto.getMediaType() + " jest już na Twojej liście!");
        }

        var watchList = Watchlist
                .builder()
                .status(statusRepository.findByName(watchlistDto.getStatus()).orElseThrow(() -> new NotFoundException("Error: Status is not found")))
                .mediaType(mediaTypeRepository.findMediaTypeByName(watchlistDto.getMediaType()).orElseThrow(() -> new NotFoundException("Error: MediaType is not found")))
                .tmdbId(watchlistDto.getTmdbId())
                .rating(watchlistDto.getRating())
                .user(user)
                .build();

        watchlistRepository.save(watchList);

    }
    @Override
    public void deleteFromWatchList(DeleteWatchlistDto deleteWatchlistDto)
    {
        User user = getCurrentUser();

        if (!watchlistRepository.existsByUserIdAndTmdbIdAndMediaType_Name(user.getId(), deleteWatchlistDto.getTmdbId(), deleteWatchlistDto.getMediaTypeName())) {
            throw new BadRequestException("Ten film nie jest na Twojej liście!");
        }

        watchlistRepository.deleteByTmdbIdAndUserIdAndMediaType_Name(deleteWatchlistDto.getTmdbId(), user.getId(), deleteWatchlistDto.getMediaTypeName());
    }

    @Override
    public void changeStatus(EditStatusWatchlistDto request)
    {
        User user = getCurrentUser();

        Watchlist item = watchlistRepository.findByUserIdAndTmdbIdAndMediaType_Name(
                user.getId(),
                request.getTmdbId(),
                request.getMediaTypeName()
        ).orElseThrow(() -> new NotFoundException("Nie znaleziono pozycji na liście"));

        Status newStatus = statusRepository.findByName(request.getStatus())
                .orElseThrow(() -> new NotFoundException("Nieznany status"));

        item.setStatus(newStatus);
        watchlistRepository.save(item);
    }

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

}
