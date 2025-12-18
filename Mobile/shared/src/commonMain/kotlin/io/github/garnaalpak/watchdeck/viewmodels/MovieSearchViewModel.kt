package io.github.garnaalpak.watchdeck.viewmodels

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.github.garnaalpak.watchdeck.repositories.TmdbRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieSearchViewModel : ViewModel() {
    private val repository = TmdbRepository()
    private val _state = MutableStateFlow<SearchState>(SearchState.Idle)
    val state = _state.asStateFlow()

    fun searchMovies(query: String) {
        viewModelScope.launch {

            _state.value = SearchState.Loading

            try {
                val movies = repository.searchMovies(query)
                if (movies.isEmpty()) {
                    _state.value = SearchState.Error("Nie znaleziono filmów dla frazy: $query")
                } else {
                    _state.value = SearchState.Success(movies)
                }
            } catch (e: Exception) {
                _state.value = SearchState.Error(e.message ?: "Wystąpił błąd")
            }
        }
    }
}