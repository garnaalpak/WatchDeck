package io.github.garnaalpak.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditStatusWatchlistDto implements Serializable {
    @NotNull
    private String mediaTypeName;
    @NotNull
    private String tmdbId;
    @NotNull
    private String status;
}