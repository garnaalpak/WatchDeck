package io.github.garnaalpak.backend.dto;

import lombok.*;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistResponseDto implements Serializable {
    private String mediaTypeName;
    private String statusName;
    private String tmdbId;
    private Double rating;
}