package io.github.garnaalpak.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditStatusWatchlistDto implements Serializable {
    @NotBlank(message = "Typ mediów jest wymagany")
    private String mediaTypeName;

    @NotBlank(message = "ID TMDB jest wymagane")
    private String tmdbId;

    @NotBlank(message = "Status jest wymagany")
    private String status;
}