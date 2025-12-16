package io.github.garnaalpak.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddWatchlistDto implements Serializable {

    private String tmdbId;

    private String mediaType;

    private String status;

    private Double rating;
}