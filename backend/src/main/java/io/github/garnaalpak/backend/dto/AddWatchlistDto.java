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
public class AddWatchlistDto implements Serializable {


    @NotBlank(message = "TMDB ID jest wymagane")
    private String tmdbId;

    @NotBlank(message = "Typ mediów jest wymagany")
    private String mediaType;

    @NotBlank(message = "Status jest wymagany")
    private String status;

    private Double rating;
}