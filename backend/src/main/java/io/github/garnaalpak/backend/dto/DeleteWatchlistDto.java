package io.github.garnaalpak.backend.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteWatchlistDto implements Serializable {
    String mediaTypeName;
    String tmdbId;
}