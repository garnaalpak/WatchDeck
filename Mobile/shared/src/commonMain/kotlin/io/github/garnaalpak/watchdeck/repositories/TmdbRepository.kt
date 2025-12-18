package io.github.garnaalpak.watchdeck.repositories

import io.github.garnaalpak.watchdeck.models.TmdbItem
import io.github.garnaalpak.watchdeck.models.TmdbSearchResponse
import io.github.garnaalpak.watchdeck.network.KtorClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class TmdbRepository {
    private val client = KtorClient.client

    private val apiKey = "b111e368f706feb9ebbe52a31057522a"


    suspend fun searchMovies(query: String): List<TmdbItem> {
        try {
            val response: TmdbSearchResponse = client.get("https://api.themoviedb.org/3/search/multi") {
                parameter("api_key", apiKey)
                parameter("query", query)
                parameter("language", "pl-PL")
                parameter("include_adult", "false") // Warto dodać, żeby nie pokazywało dziwnych filmów ;)
            }.body()

            return response.results
        } catch (e: Exception) {
            println("Błąd: ${e.message}")
            return emptyList()
        }
    }
}