package io.github.garnaalpak.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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