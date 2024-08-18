package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    val pokemonData = MutableLiveData<Pokemon?>()

    fun fetchPokemon(name: String) {
        viewModelScope.launch {
            val pokemon = repository.getPokemonByName(name)
            pokemonData.value = pokemon
        }
    }
}