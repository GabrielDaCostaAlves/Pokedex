package com.example.pokedex.data.repository

import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.network.api.PokeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository(private val apiService: PokeApiService) {
    suspend fun getPokemonByName(name: String): Pokemon? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getPokemon(name)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}