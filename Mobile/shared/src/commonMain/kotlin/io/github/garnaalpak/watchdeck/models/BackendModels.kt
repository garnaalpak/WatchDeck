package io.github.garnaalpak.watchdeck.models

import kotlinx.serialization.Serializable

@Serializable
data class AddWatchlistRequest(
    val tmdbId: String,
    val mediaType: String,
    val status: String,
    val rating: Double?
)

@Serializable
data class AuthRequest(
    val username: String,
    val password: String
)

@Serializable
data class AuthResponse(
    val token: String
)

@Serializable
data class EditWatchlistRequest(
    val mediaTypeName: String,
    val tmdbId: String,
    val status: String
)

@Serializable
data class RegisterRequest(
    val firstname: String,
    val username: String,
    val email: String,
    val password: String
)

@Serializable
data class SimpleMessResponse(
    val message: String
)

@Serializable
data class UserResponse(
    val firstname: String,
    val username: String,
    val email: String,
    val roleName: String
)

@Serializable
data class WatchlistResponse(
    val mediaTypeName: String,
    val statusName: String,
    val tmdbId: String,
    val rating: Double
)

@Serializable
data class BackendError(
    val status: Int,
    val error: String,
    val message: String,
    val timestamp: Long
)
