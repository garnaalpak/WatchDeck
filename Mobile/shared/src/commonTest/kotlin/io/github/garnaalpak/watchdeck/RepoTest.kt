package io.github.garnaalpak.watchdeck

import io.github.garnaalpak.watchdeck.repositories.TmdbRepository
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class RepoTest {

    @Test
    fun `test searching movies`() = runTest {
        // 1. Tworzymy repozytorium
        val repo = TmdbRepository()

        // 2. Szukamy filmów z frazą "Batman"
        println("🎬 Szukam filmów...")
        val movies = repo.searchMovies("Batman")

        // 3. Wypisujemy wyniki w konsoli
        movies.forEach { movie ->
            println("Znaleziono: ${movie.title ?: movie.name} (Ocena: ${movie.voteAverage})")
        }

        // 4. Sprawdzamy, czy coś znaleziono (test przejdzie na zielono, jeśli lista nie jest pusta)
        assertTrue(movies.isNotEmpty(), "Nie znaleziono żadnych filmów! Sprawdź klucz API.")
    }
}