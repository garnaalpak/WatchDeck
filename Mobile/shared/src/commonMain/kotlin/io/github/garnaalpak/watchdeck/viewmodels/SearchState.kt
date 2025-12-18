package io.github.garnaalpak.watchdeck.viewmodels

import io.github.garnaalpak.watchdeck.models.TmdbItem

sealed interface SearchState {

    data object Idle : SearchState

    data object Loading : SearchState

    data class Success(val movies: List<TmdbItem>) : SearchState

    data class Error(val message: String) : SearchState
}