package io.github.garnaalpak.watchdeck.models

import kotlinx.serialization.Serializable

@Serializable
data class WatchlistResponse(
    val id: Int,
    val tmdbId: String,
    val status: String,
    val rating: Double?
)