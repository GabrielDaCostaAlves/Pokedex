package com.example.pokedex.network

import com.example.pokedex.network.api.PokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {


    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    fun getApiService(): PokeApiService {
        return retrofit.create(PokeApiService::class.java)
    }
}