package io.github.garnaalpak.watchdeck.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class TmdbSearchResponse(
    val page: Int,
    val results: List<TmdbItem>,
    @SerialName("total_pages") val totalPages: Int
)

@Serializable
data class TmdbItem(
    val id: Int,
    val title: String? = null,
    val name: String? = null,

    @SerialName("poster_path")
    val posterPath: String? = null,

    @SerialName("vote_average")
    val voteAverage: Double? = null,

    @SerialName("release_date")
    val releaseDate: String? = null,

    @SerialName("first_air_date")
    val firstAirDate: String? = null,

    val overview: String? = null
)


val TmdbItem.displayTitle: String
    get() = title ?: name ?: "Nieznany tytuł"

val TmdbItem.fullPosterUrl: String
    get() = if (posterPath != null) {
        "https://image.tmdb.org/t/p/w500$posterPath"
    } else {
        "https://placehold.co/500x750?text=Brak+Okladki"
    }

val TmdbItem.releaseYear: String
    get() {
        val date = releaseDate ?: firstAirDate
        return date?.take(4) ?: "---"
    }