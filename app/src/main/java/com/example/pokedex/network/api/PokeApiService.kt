package com.example.pokedex.network.api

import com.example.pokedex.data.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") name: String): Response<Pokemon>
}