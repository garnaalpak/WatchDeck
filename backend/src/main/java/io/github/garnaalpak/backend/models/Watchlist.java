package io.github.garnaalpak.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_type_id")
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "tmdbid")
    private String tmdbId;

    @Column(name = "rating")
    private Double rating;





}